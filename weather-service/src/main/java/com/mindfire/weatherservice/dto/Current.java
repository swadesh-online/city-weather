package com.mindfire.weatherservice.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown =true)
public class Current
{
    @JsonAlias("last_updated_epoch")
	private int lastUpdatedEpoch;
    

    @JsonAlias("last_updated")
    private String lastUpdated;
    

    @JsonAlias("temp_c")
    private int tempC;
    
  
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

    
    @JsonAlias("vis_km")
    private int visKm;
    
    
    @JsonAlias("vis_miles")
    private int visMiles;

    
    private int uv;

    
    @JsonAlias("gust_mph")
    private double gustMph;
    
    
    @JsonAlias("gust_kph")
    private double gustKph;
    
    
    @JsonAlias("air_quality")
    private AirQuality airQuality;

   
}