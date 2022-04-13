package com.mindfire.cityservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Document("cities")
public class City {
   

	@Id
    private String cityId;

    private String name;
    
    
    public City(String name) {
		this.name = name;
	}
    
}
