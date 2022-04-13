package com.mindfire.cityservice.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown =true)

public class Forecast
{
    private List<Forecastday> forecastday;

}