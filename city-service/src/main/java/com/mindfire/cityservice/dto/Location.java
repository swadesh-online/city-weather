package com.mindfire.cityservice.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) 
public class Location
{
    private String name;

    private String region;

    private String country;

    private double lat;

    private double lon;
    
    @JsonAlias("tz_id")
    private String tzId;
    
    @JsonAlias("localtime_epoch")
    private int localtimeEpoch;

    private String localtime;

}