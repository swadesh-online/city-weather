package com.mindfire.weatherservice.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mindfire.weatherservice.exception.ErrorDetails;
import com.mindfire.weatherservice.exception.GenericException;
import com.mindfire.weatherservice.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  
	
	/**
	 * This method is used to handle ResourceNotFoundException(on not finding the city weather details in the external API).
	 * @param ex
	 * @return {@link ResponseEntity}
	 */
   @ExceptionHandler(ResourceNotFoundException.class)
   protected ResponseEntity<Object> handleResourceNotFound(
		   ResourceNotFoundException ex) {
	   
	   Date date = new Date();
	   ErrorDetails errorDetails= new ErrorDetails(date.toString(),"Desired city is missing in the API.", "NOT_FOUND", "404" );
       return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
   
   
   /**
	 * This method is used to handle GenericExceptions.
	 * @param ex
	 * @return {@link ResponseEntity}
	 */
   @ExceptionHandler(GenericException.class)
   protected ResponseEntity<Object> handleGenericException(
		   GenericException ex) {
	   
	   Date date = new Date();
	   ErrorDetails errorDetails= new ErrorDetails(date.toString(),"Something went wrong.", "REQUEST_TIMEOUT", "408" );
       return new ResponseEntity<>(errorDetails, HttpStatus.REQUEST_TIMEOUT);
   }
}
