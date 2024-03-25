package com.example.LoginExample.Controller;

import ch.qos.logback.core.model.Model;
import com.example.LoginExample.Model.FileFormat;
import com.example.LoginExample.Services.FileService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;



//    @PostMapping("/photos/add")
//    public String addPhoto(@RequestParam("title") String title,
//                           @RequestParam("image") MultipartFile image, Model model)
//            throws IOException {
//        String id = fileService.addPhoto(title, image);
//        return "redirect:/photos/" + id;
//    }
//
//    @GetMapping("/photos/{id}")
//    public String getPhoto(@PathVariable String id, org.springframework.ui.Model model) {
//        FileFormat photo = fileService.getPhoto(id);
//        model.addAttribute("title", photo.getTitle());
//        model.addAttribute("image",
//                Base64.getEncoder().encodeToString(photo.getImage().getData()));
//        return "photos";
//    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) throws IOException {
        return new ResponseEntity<>(fileService.addFile(file), HttpStatus.OK);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
        FileFormat loadFile = fileService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(loadFile.getFileType() ))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + loadFile.getFilename() + "\"")
                .body(new ByteArrayResource(loadFile.getFile()));
    }

}
