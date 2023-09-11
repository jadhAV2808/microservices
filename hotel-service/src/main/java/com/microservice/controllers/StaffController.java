package com.microservice.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

@RestController
@RequestMapping("/staffs")
public class StaffController {

	@GetMapping
	public ResponseEntity<List<String>>getStaffs(){
		
		List<String> list=Arrays.asList("Ram","Priya","sheela");
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}