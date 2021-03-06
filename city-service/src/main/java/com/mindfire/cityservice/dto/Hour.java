package com.mindfire.cityservice.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown =true)
public class Hour
{	
	@JsonAlias("time_epoch")
	private int timeEpoch;

	private String time;

	@JsonAlias("temp_c")
	private double tempC;

	@JsonAlias("temp_f")
	private double tempF;

	@JsonAlias("is_day")
	private int isDay;

	private Condition condition;

	@JsonAlias("wind_mph")
	private double windMph;

	@JsonAlias("wind_kph")
	private double windKph;

	@JsonAlias("wind_degree")
	private int windDegree;

	@JsonAlias("wind_dir")
	private String windDir;

	@JsonAlias("pressure_mb") 
	private int pressureMb;

	@JsonAlias("pressure_in") 
	private double pressureIn;

	@JsonAlias("precip_mm") 
	private int precipMm;

	@JsonAlias("precip_in") 
	private int precipIn;

	private int humidity;

	private int cloud;

	@JsonAlias("feelslike_c") 
	private double feelslikeC;

	@JsonAlias("feelslike_f") 
	private double feelslikeF;

	@JsonAlias("windchill_c") 
	private double windchillC;


	@JsonAlias("windchill_f") 
	private double windchillF;

	@JsonAlias("heatindex_c") 
	private double heatindexC;

	
	@JsonAlias("heatindex_f") 
	private double heatindexF;

	
	@JsonAlias("dewpoint_c") 
	private double dewpointC;

	
	@JsonAlias("dewpoint_f") 
	private double dewpointF;

	
	@JsonAlias("will_it_rain") 
	private int willItRain;

	@JsonAlias("chance_of_rain")
	private int chanceOfRain;


	@JsonAlias("will_it_snow")
	private int willItSnow;

	
	@JsonAlias("chance_of_snow") 
	private int chanceOfSnow;


	@JsonAlias("vis_km") 
	private int visKm;


	@JsonAlias("vis_miles") 
	private int visMiles;


	@JsonAlias("gust_mph") 
	private double gustMph;


	@JsonAlias("gust_kph") 
	private double gustKph;

	private int uv;



}
