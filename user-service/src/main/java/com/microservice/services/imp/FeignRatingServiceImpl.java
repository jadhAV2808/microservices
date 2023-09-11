package com.microservice.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.ext.services.RatingService;
import com.microservice.models.Rating;

@Service
public class FeignRatingServiceImpl {
	
	@Autowired
	private RatingService ratingService;
	
	//to test feign client-- RatingService
		public List<Rating> getAllRatings(){
			return ratingService.getAllRatings();
		}
		

}
