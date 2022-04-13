package com.mindfire.cityservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mindfire.cityservice.model.City;

public interface CityRepository extends MongoRepository<City,String>{
	
	
}
