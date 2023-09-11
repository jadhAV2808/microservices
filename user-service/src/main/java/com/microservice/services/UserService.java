package com.microservice.services;

import java.util.List;


import com.microservice.models.User;



public interface  UserService{
	
	//create
	User saveUser(User user);
	
	//get all user
	List<User> getAllUser();
	
	//get single user
	User getUser(String userId);
	

	
}
