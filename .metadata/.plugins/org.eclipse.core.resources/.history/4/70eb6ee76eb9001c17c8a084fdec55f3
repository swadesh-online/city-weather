package com.mindfire.weatherservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown =true)
public class Forecastday
{
    private String date;
    
   	@JsonAlias("date_epoch")
    private int dateEpoch;

    private Day day;

    private Astro astro;

    private List<Hour> hour;

    
}