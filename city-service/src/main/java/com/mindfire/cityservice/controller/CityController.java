package com.mindfire.cityservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindfire.cityservice.model.City;
import com.mindfire.cityservice.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	public CityService cityService;
	
	/**
	 * This method adds a city to the CityList
	 * 
	 * @param cityName - The name of the city to be added and returns updated list
	 * @return {@link ResponseEntity} 
	 */
	@PostMapping("")
	private ResponseEntity<?> add(@RequestBody String cityName) {
		
		return cityService.add(cityName);
	}
	
	/**
	 *  This method fetches all the city names from the city List and returns updated list
	 * 
	 * @return List<City>
	 */
	@GetMapping("/all")
	private List<City> fetchAll(){
		
		return cityService.fetchAll();
	}
	
	
	
	/**
	 *  This method removes the city name from the list and returns updated list
	 * 
	 * @param cityName
	 * @return {@link ResponseEntity} 
	 */
	@DeleteMapping("/{cityId}")
	private ResponseEntity<?> delete(@PathVariable("cityId") String cityId){
		
		return cityService.delete(cityId);
	}
	

	
}
