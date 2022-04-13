package com.mindfire.weatherservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown =true)
public class Condition
{
    private String text;

    private String icon;

    private int code;

}