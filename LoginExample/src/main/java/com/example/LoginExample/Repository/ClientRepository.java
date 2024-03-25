package com.example.LoginExample.Repository;

import com.example.LoginExample.Model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client,Integer> {
    Optional<Client> findBycustomerEmail(String customerEmail);
}
