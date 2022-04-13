package com.mindfire.cityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableMongoRepositories
@OpenAPIDefinition
public class CityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityServiceApplication.class, args);
	}


}
