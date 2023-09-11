package com.microservice.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.exceptions.ResourceNotFoundException;
import com.microservice.models.Hotel;
import com.microservice.repository.HotelRepo;
import com.microservice.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel create(Hotel hotel) {
		
		String randomHotelId =UUID.randomUUID().toString();
		hotel.setHotelId(randomHotelId);
		
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		
		return hotelRepo.findHotelByHotelId(hotelId).orElseThrow( ()-> new ResourceNotFoundException("Hotel with given Id not found "+ hotelId));
	}

}
