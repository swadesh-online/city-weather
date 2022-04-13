package com.mindfire.cityservice.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown =true)
public class Astro
{
    private String sunrise;

    private String sunset;

    private String moonrise;

    private String moonset;
    
    @JsonAlias("moon_phase")
    private String moonPhase;
    
    @JsonAlias("moon_illumination")
    private String moonIllumination;

   
}