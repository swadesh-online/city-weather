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

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	WeatherConsumerService weatherConsumer;

	@Autowired
	CityRepository cityRepository;

	/**
	 * This method adds city to the cityList
	 * 
	 * @param cityName - The name of the city to be added
	 * @return {@link ResponseEntity} : returns Success message on successful addition 
	 * 
	 */
	public ResponseEntity<?> add(String cityName) {

		// Checks if city is present in Api
		if (IsValidatedInApi(cityName)) {

			List<City> existingCities = cityRepository.findAll();
			boolean cityFound = false;
			for (City city : existingCities) {

				// Checks if city is already present in list, else save.
				if (city.getName().equalsIgnoreCase(cityName)) {

					cityFound = true;
					throw new GenericException("The city is already present.");
				}
			}
			if (!cityFound) {

				cityRepository.save(new City(cityName.toLowerCase()));
			}
			
		}
		return new ResponseEntity<Object>("SUCCESS",HttpStatus.OK);
	}
	
	
	/**
	 * This method is used to check if the city weather details are present in API.
	 * @param cityName
	 * @return boolean : isValid 
	 */
	public boolean IsValidatedInApi(String cityName) {
		try {
			
			weatherConsumer.getWeather(cityName);
			
			return true;
		} catch (FeignClientException fce) {
			
			throw new ResourceNotFoundException();
		}
	}

	/**
	 * This method is used to fetch all cities from the cityList
	 * 
	 * @return List<City> - updated cityList
	 * 
	 */
	public List<City> fetchAll() {

		return cityRepository.findAll();
	}

	/**
	 * This method is used to remove city from the cityList
	 * 
	 * @param cityId - The cityId to be removed
	 * @return {@link ResponseEntity} : returns Success message on successful deletion. 
	 * 
	 */
	public ResponseEntity<?> delete(String cityId) {

		// Checks if the cityName is present in the list, if found removes it.
		List<City> existingCities = cityRepository.findAll();
		for (City city : existingCities) {

			if (city.getCityId().equals(cityId)) {

				cityRepository.delete(city);

			}
		}

		return new ResponseEntity<Object>("SUCCESS",HttpStatus.OK);
	}
}
