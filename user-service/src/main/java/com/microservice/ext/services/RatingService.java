package com.microservice.ext.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.models.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	
	//get 
	@GetMapping("/ratings")
	List<Rating>getAllRatings();
	
	//post
	@PostMapping("/ratings")
	Rating createRating( Rating rating);
	
	
	/*
	//put
	@PutMapping("/ratings/{ratingI}")
	Rating updateRating(@PathVariable String ratingId, Rating rating);
	
	
	//delete
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
	*/
}
