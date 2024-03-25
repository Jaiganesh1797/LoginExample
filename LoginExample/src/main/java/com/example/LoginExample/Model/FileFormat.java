package com.example.LoginExample.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "file_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileFormat {

        @Id
        private String filename;
        private String fileType;
        private String fileSize;
        private byte[] file;

}
