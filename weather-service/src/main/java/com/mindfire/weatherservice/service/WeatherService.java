package com.mindfire.weatherservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.mindfire.weatherservice.dto.Weather;
import com.mindfire.weatherservice.exception.GenericException;
import com.mindfire.weatherservice.exception.ResourceNotFoundException;

@Service
public class WeatherService {
	
    @Bean
    RestTemplate restTemplate() {
    	
    	return new RestTemplate();
    }

	
	
	/**
	 *  This method is used to get Weather Details of any city
	 * @param city
	 * @return {@link Weather} : return the weather report of desired city.
	 */
	public Weather getWeatherReport(String city)  {	
			String formattedCityName= city.trim().replaceAll(" ", "");
		String url="http://api.weatherapi.com/v1/forecast.json?key=483a04daff914ce58f991903220803&q={city}&days={days}";
		try {
		ResponseEntity<Weather> response = this.restTemplate().getForEntity(url, Weather.class,formattedCityName,"7");
		return response.getBody();
		}catch(HttpClientErrorException ex) {
			throw new ResourceNotFoundException();
		}
		catch(HttpServerErrorException ex) {
			throw new GenericException();
		}
		}
}
