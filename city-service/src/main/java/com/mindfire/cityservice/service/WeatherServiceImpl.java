package com.mindfire.cityservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfire.cityservice.dto.CityWeatherReport;
import com.mindfire.cityservice.dto.Weather;
import com.mindfire.cityservice.exception.GenericException;
import com.mindfire.cityservice.model.City;
import com.mindfire.cityservice.repository.CityRepository;

@Service
public class WeatherServiceImpl implements WeatherService {


	@Autowired
	WeatherConsumerService weatherConsumer;
	
	@Autowired
	CityRepository cityRepository;
	
	
	
	/**
	 *  This method is used to fetch the Weather Report of a city.
	 *  
	 * @param cityId : The cityId which needs to be searched in database and return the cityName associated. 
	 * @return {@link Weather} : returns WeatherReport for a single city. 
	 */
	public Weather getWeatherReport(String cityId) {
		
		Optional<City> city =cityRepository.findById(cityId);
		
		if(city!=null) {
		
			Weather weather = weatherConsumer.getWeather(city.get().getName());
			
			return weather;
		
		}else {
			
			throw new GenericException("No city found by the requested Id.");
		}
		
	}
	
	
	
	
	
	
	/**
	 *  This method is used to fetch the Weather Report of all the cities in cityList
	 *  
	 * @return {@link List<CityWeatherReport>}
	 */
	public List<CityWeatherReport> getWeatherReports() {
		 
		List<CityWeatherReport> weatherReports = new ArrayList<CityWeatherReport>();
		
		//Iterating all the cities in the City List
		List<City> existingCities = cityRepository.findAll();
		
		for(City city : existingCities) {
			
			Weather weatherObj = weatherConsumer.getWeather(city.getName());
			
			//Checking for Null values
			if(weatherObj != null 
					&& weatherObj.getLocation() != null 
					&& weatherObj.getCurrent() != null
					&& weatherObj.getForecast()!=null) {
				
				// Adding weatherReport to the weatherReports List.  
				weatherReports.add(
						new CityWeatherReport(
								city.getCityId(),
								weatherObj.getLocation().getName(), 
								weatherObj.getLocation().getLocaltime(),
								weatherObj.getCurrent().getCondition().getText(), 
								weatherObj.getForecast().getForecastday().get(0).getDay().getMaxtempC(),
								weatherObj.getForecast().getForecastday().get(0).getDay().getMintempC(),
								weatherObj.getCurrent().getCondition().getIcon()));
			}
		}
		
		return weatherReports;
	}


	

}
