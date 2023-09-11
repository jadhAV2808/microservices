package com.microservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.exceptions.ResourceNotFoundException;
import com.microservice.models.Rating;
import com.microservice.repository.RatingRepo;
import com.microservice.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating create(Rating rating) {
		
		String randomUserId =UUID.randomUUID().toString();
		rating.setRatingId(randomUserId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return ratingRepo.findAllByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		
		return ratingRepo.findAllByHotelId(hotelId);
	}

	@Override
	public Rating getRatingById(String ratingId) {
		
		return ratingRepo.findByRatingId(ratingId).orElseThrow(()-> new ResourceNotFoundException("Rating with given id is not found on server : "+ratingId ));
	
	}

}
