package com.example.reactivedemo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends ReactiveMongoRepository<User,Integer> {
    public User findByName(String name);

}
