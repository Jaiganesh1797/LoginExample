package com.example.LoginExample.Services;

import com.example.LoginExample.Model.FileFormat;
import com.example.LoginExample.Repository.FileRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.apache.tomcat.util.http.fileupload.IOUtils.*;


@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;


    @Autowired
    private GridFsOperations operations;
    @Autowired
    private GridFsTemplate template;

    @Autowired
    private FileRepository fileInfoRepository;


    public String addFile(MultipartFile upload)throws IOException {

        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", upload.getSize());
        Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);
        return fileID.toString();
    }


    public FileFormat downloadFile(String id) throws IOException {
        GridFSFile gridFSFile = operations.findOne(new Query(Criteria.where("_id").is(id)));

        FileFormat loadFile = null;

        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            loadFile = new FileFormat();
            loadFile.setFilename(gridFSFile.getFilename());
            loadFile.setFileType(gridFSFile.getMetadata().get("_contentType").toString());

            // Convert file size to appropriate data type
            Object fileSizeObj = gridFSFile.getMetadata().get("fileSize");
            if (fileSizeObj instanceof Number) {
                loadFile.setFileSize(String.valueOf(((Number) fileSizeObj).longValue()));
            }

            // Download file content
            byte[] fileContent = StreamUtils.copyToByteArray(operations.getResource(gridFSFile).getInputStream());
            loadFile.setFile(fileContent);
        }

        return loadFile;
    }

}

