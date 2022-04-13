package com.mindfire.weatherservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true) 
public class Weather
{
    private Location location;

    private Current current;

    private Forecast forecast;

    
}