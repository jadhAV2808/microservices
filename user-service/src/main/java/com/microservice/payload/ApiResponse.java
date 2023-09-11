package com.microservice.payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	
	private String message;
	private boolean isSuccess;
	private HttpStatus status;
	
	
	public ApiResponse() {
		
	}


	public ApiResponse(String message, boolean isSuccess, HttpStatus status) {
		super();
		this.message = message;
		this.isSuccess = isSuccess;
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public boolean isSuccess() {
		return isSuccess;
	}


	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
	//builder pattern

	
	
	

}
