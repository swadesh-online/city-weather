package com.mindfire.cityservice.service;

import java.util.List;

import com.mindfire.cityservice.dto.CityWeatherReport;
import com.mindfire.cityservice.dto.Weather;

public interface WeatherService {


	/**
	 *  This method is used to fetch the Weather Report of a city.
	 *  
	 * @param cityId : The cityId which needs to be searched in database and return the cityName associated. 
	 * @return {@link Weather} : returns WeatherReport for a single city. 
	 */
	public Weather getWeatherReport(String cityId);
	
	
	/**
	 *  This method is used to fetch the Weather Report of all the cities in cityList
	 *  
	 * @return {@link List<CityWeatherReport>}
	 */
	public List<CityWeatherReport> getWeatherReports();


	

}
