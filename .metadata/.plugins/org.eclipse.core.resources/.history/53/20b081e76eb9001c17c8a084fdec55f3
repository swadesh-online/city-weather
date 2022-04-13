package com.mindfire.weatherservice.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown =true)
public class AirQuality {
	
	private int co;

	private double no2;

	private double o3;

	private double so2;
	
	@JsonAlias("pm2_5")
	private double pm2Dot5;

	private double pm10;

}
