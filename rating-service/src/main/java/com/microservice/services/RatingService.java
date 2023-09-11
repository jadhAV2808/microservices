package com.microservice.services;

import java.util.List;

import com.microservice.models.Rating;

public interface RatingService {
	
	//create
	
	Rating create(Rating rating);
	
	//getAll
	List<Rating>getAllRatings();

	//getRatingById
	
	//getAllByUserId
	List<Rating>getRatingByUserId(String userId);
	
	//getAllByHotel
	List<Rating> getRatingByHotelId(String hotelId);
	
	Rating getRatingById(String ratingId);
	
	
}
