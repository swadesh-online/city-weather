package com.mindfire.cityservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindfire.cityservice.dto.CityWeatherReport;
import com.mindfire.cityservice.dto.Weather;
import com.mindfire.cityservice.model.City;
import com.mindfire.cityservice.service.WeatherService;

@RestController
@RequestMapping("/city/weather")
public class WeatherController {
	
	@Autowired
	public WeatherService weatherService;
	
	
	/**
	 *  This method provides WeatherReport of a city.
	 * 
	 * @return {@link Weather}
	 */
	@GetMapping("/{cityId}")
	private Weather fetchSingleReport(@PathVariable("cityId") String cityId){
		
		return weatherService.getWeatherReport(cityId);
	}
	
	
	/**
	 *  This method provides the List of WeatherReports of all the cities in the cityList.
	 * 
	 * @return {@link List<CityWeatherReport>}
	 */
	@GetMapping("/all")
	public List<CityWeatherReport> getWeatherReports() {
		
		return weatherService.getWeatherReports();
	}
	
}
