package com.mindfire.cityservice.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindfire.cityservice.dto.Weather;

@FeignClient(name="weather-api")
public interface WeatherConsumerService {
	
	/**
	 *  Method declaration for fetching all weather details for a city from weather-service
	 * 
	 * @param city - The name of the city for which the details needs to be fetched
	 * @return
	 */
	 @GetMapping("/weather/{city}")
     Weather getWeather(@PathVariable("city") String city);
	 
}
