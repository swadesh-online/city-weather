package com.mindfire.cityservice.exception;

import lombok.Data;

@Data
public class GenericException extends RuntimeException{

	
	private String message;
	
	public GenericException(String message) {
		this.message = message;
	}
	
	
}
