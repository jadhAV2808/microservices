package com.microservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.models.Hotel;

@Repository
public interface  HotelRepo extends MongoRepository<Hotel, String>{

	Optional<Hotel> findHotelByHotelId(String hotelId);
}
