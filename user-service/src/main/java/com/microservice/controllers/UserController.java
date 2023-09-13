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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

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
	
	int retryCount=1;
	
	//get single user
	@GetMapping("/{userId}")
	
	/* now commenting this circuitBreaker annotation for retry  */
	//@CircuitBreaker(name="ratingHotelBreaker", fallbackMethod="ratingHotelFallback")
	
	
	/* now commenting this Retry to implement RateLimiter */
	//@Retry(name="ratingHotelRetry", fallbackMethod="ratingHotelFallback")
	
	@RateLimiter(name="userRateLimiter" ,fallbackMethod="ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		
		System.out.println("Retry count-----------------"+retryCount );
		retryCount++;
		
		User user1 = userService.getUser(userId);
		return ResponseEntity.ok(user1);
	}
	

	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
		
		System.out.println(" This Fallback is executed because service is down!!! ");
		User user=new User();
		user.setUserId("dummy123");
		user.setName("Dummy");
		user.setEmail("dummy@gmail.com");
		user.setAbout("This user is created dummy because some of services are down...");
		return new ResponseEntity<>(user, HttpStatus.OK);
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
