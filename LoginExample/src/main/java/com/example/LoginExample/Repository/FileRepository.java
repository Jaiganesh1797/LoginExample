package com.example.LoginExample.Repository;

import com.example.LoginExample.Model.FileFormat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends MongoRepository<FileFormat,String> {

}
