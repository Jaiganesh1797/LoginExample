package com.example.LoginExample.Services;

import com.example.LoginExample.Model.FileFormat;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {

    public String addFile(MultipartFile upload) throws IOException ;
    public FileFormat downloadFile(String id) throws IOException;

}
