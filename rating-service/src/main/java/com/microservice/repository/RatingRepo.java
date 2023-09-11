package com.microservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.models.Rating;

@Repository
public interface RatingRepo  extends MongoRepository<Rating, String>{
	
	//custom finder methods
	
	List<Rating>findAllByUserId(String userId);
	
	List<Rating>findAllByHotelId(String hotelId);
	
	Optional<Rating> findByRatingId(String ratingId);
	

}
