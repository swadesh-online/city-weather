package com.mindfire.weatherservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindfire.weatherservice.dto.Weather;
import com.mindfire.weatherservice.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	

	/**
	 * This method returns Weather Details of any City
	 * 
	 * @param city - The name of the city for which weather needs to be fetched
	 * 
	 * @return {@link Weather} 
	 */
	@GetMapping("/{city}")
	private Weather getWeatherReport(@PathVariable("city") String city) {
			
		return weatherService.getWeatherReport(city);
	}
	
}
