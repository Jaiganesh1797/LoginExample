package com.example.LoginExample.Repository;

import com.example.LoginExample.Model.Register;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<Register,Integer> {

    Optional<Register> findByregName(String regName);
    Optional<Register> findByregPassword(String regPassword);
}
