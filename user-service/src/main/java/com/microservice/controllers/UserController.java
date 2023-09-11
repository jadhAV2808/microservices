package com.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.models.Rating;
import com.microservice.models.User;
import com.microservice.services.UserService;
import com.microservice.services.imp.FeignRatingServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//get single user
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		
		User user1 = userService.getUser(userId);
		return ResponseEntity.ok(user1);
	}
	
	//get single user
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = userService.getAllUser();
		return ResponseEntity.ok(allUsers);
	}
	
	
	
	/* to test feign client  */
	
	@Autowired 
	private FeignRatingServiceImpl feignRatingServiceImpl;
	
	
	@GetMapping("/feign")
	public List<Rating> getAllRatings(){
		System.out.println("feignRatings--------------feignRatings------------------feignRatings------------");
		return feignRatingServiceImpl.getAllRatings();
	}
	

	
	
}
