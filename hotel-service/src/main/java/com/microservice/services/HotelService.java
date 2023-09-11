package com.microservice.services;

import java.util.List;

import com.microservice.models.Hotel;

public interface HotelService {
	
	//create
	Hotel create(Hotel hotel);
	
	//getAll
	List<Hotel>getAll();
	
	//get single
	Hotel getHotelById(String hotelId);

}
