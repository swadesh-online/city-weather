package com.mindfire.weatherservice.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown =true)
public class Day
{	
	@JsonAlias("maxtemp_c")
    private double maxtempC;
	
	@JsonAlias("maxtemp_f")
    private double maxtempF;
	
	@JsonAlias("mintemp_c")
    private double mintempC;
	
	@JsonAlias("mintemp_f")
    private double mintempF;
	
	@JsonAlias("avgtemp_c")
    private int avgtempC;
	
	@JsonAlias("avgtemp_f")
    private double avgtempF;
	
	@JsonAlias("maxwind_mph")
    private double maxwindMph;
	
	@JsonAlias("maxwind_kph")
    private double maxwindKph;
	
	@JsonAlias("totalprecip_mm")
    private int totalprecipMm;
	
	@JsonAlias("totalprecip_in")
    private int totalprecipIn;
	
	@JsonAlias("avgvis_km")
    private int avgvisKm;
	
	@JsonAlias("avgvis_miles")
    private int avgvisMiles;

    private int avghumidity;
    
	@JsonAlias("daily_will_it_rain")
    private int dailyWillItRain;
    
   	@JsonAlias("daily_chance_of_rain")
    private int dailyChanceOfRain;
    
   	@JsonAlias("daily_will_it_snow")
    private int dailyWillItSnow;
    
   	@JsonAlias("daily_chance_of_snow")
    private int dailyChanceOfSnow;

    private Condition condition;

    private int uv;

}