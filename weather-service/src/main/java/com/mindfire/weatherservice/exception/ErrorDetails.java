package com.mindfire.weatherservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDetails {
	
	private String timestamp;
	private String message;
	private String status;
	private String statusCode;

}
