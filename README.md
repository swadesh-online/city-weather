City-Weather : An Java Springboot based Weather application, 
               with UI developed in Angular 13 to display detailed weather reports of different cities of the world,
               using Weather API. 

Pre-requisites : 
  1. Java 1.8 or newer.
  2. Gradle 6.0+  
  3. Angular 13  
  4. MongoDB  

Application Structure :   

  SpringBoot Microservices:   
    1. city-service : responsible for all City related operations.   
    2. weather-service : responsible for all Weather related operations.  
    3. gateway-service : responsible for routing incoming requests to the microservices, using Eureka Server.  
    4. spring-eureka-service : Eureka server , registers all the services and discovers different instances on demand.  
  
  Angular Application:   
    1. city-service-angular : responsible for generating UI and communicate with gateway-service to access the microservices.   
    
![Untitled Diagram drawio(2)](https://user-images.githubusercontent.com/77831969/163172841-f16d4369-0f24-4b0e-8814-c4e57105c411.png)

N.B : 1.The city-service uses FeignClient to communicate with weather-service and fetch data on demand.   
      2. Swagger-UI documentation is also available at {URI}/swagger-ui/index.html 
