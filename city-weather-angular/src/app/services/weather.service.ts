import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
    //The service IP Address with which Angular will communicate. 
  private gatewayIp = "http://localhost:8080";
  private controller = "/city/weather";
  private url = this.gatewayIp.concat(this.controller);


  constructor(private http: HttpClient) { }

//This method is used to fetch weather-reports of all the cities.
public getWeatherReports():Observable<any>{

  return this.http.get<any>(this.url.concat('/all'));
}

//This method is used to fetch weather-reports of a city.
public getWeatherReport(cityId:string):Observable<any>{

  return this.http.get<any>(this.url.concat('/'+cityId));
}

}
