package com.mindfire.cityservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindfire.cityservice.exception.GenericException;
import com.mindfire.cityservice.exception.ResourceNotFoundException;
import com.mindfire.cityservice.model.City;
import com.mindfire.cityservice.repository.CityRepository;

import feign.FeignException.FeignClientException;


public interface CityService {

	/**
	 * This method adds city to the cityList
	 * 
	 * @param cityName - The name of the city to be added
	 * @return {@link ResponseEntity} : returns Success message on successful addition 
	 * 
	 */
	public ResponseEntity<?> add(String cityName);
	
	
	/**
	 * This method is used to check if the city weather details are present in API.
	 * @param cityName
	 * @return boolean : isValid 
	 */
	public boolean IsValidatedInApi(String cityName);

	
	/**
	 * This method is used to fetch all cities from the cityList
	 * 
	 * @return List<City> - updated cityList
	 * 
	 */
	public List<City> fetchAll(); 

	
	
	/**
	 * This method is used to remove city from the cityList
	 * 
	 * @param cityId - The cityId to be removed
	 * @return {@link ResponseEntity} : returns Success message on successful deletion. 
	 * 
	 */
	public ResponseEntity<?> delete(String cityId);
	
}
