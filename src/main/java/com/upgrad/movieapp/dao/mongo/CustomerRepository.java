package com.upgrad.movieapp.dao.mongo;

import com.upgrad.movieapp.entities.mongo.CustomerMongoEnitity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<CustomerMongoEnitity, Integer> {

    public CustomerMongoEnitity findByFirstName(String firstName);
    public List<CustomerMongoEnitity> findByLastName(String lastName);
}
