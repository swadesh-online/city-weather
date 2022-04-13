package com.mindfire.cityservice.dto;

import lombok.Data;

@Data
public class CityWeatherReport {
	private String id;
	private String city;
	private String localTime;
	private String condition;
	private String maxTemperature;
	private String minTemperature;
	private String imageUrl;

	public CityWeatherReport(String id,String city, String localTime, String condition, double maxTemperature, double minTemperature, String imageUrl) {
		
		super();
		this.id=id;
		this.city = city;
		this.localTime= localTime;
		this.condition = condition;
		this.maxTemperature = Double.toString(maxTemperature);
		this.minTemperature = Double.toString(minTemperature);
		this.imageUrl = imageUrl;
	}

	
	
}
