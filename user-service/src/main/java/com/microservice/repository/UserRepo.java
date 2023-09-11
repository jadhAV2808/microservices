package com.microservice.repository;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.models.User;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
	
	Optional<User> findByUserId(String userId);

}
