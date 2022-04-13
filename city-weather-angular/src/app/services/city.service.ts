import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  //The service IP Address with which Angular will communicate. 
  private gatewayIp = "http://localhost:8080";
  private controller = "/city";
  private url = this.gatewayIp.concat(this.controller);
  
  constructor(private http:HttpClient) { }


  //This method is used to add city (cityName) to the db and will return the updated cityList.
  public addCity(cityName:string):Observable<any>{
    
    return this.http.post(this.url, cityName , {responseType : 'text'});
  }

  //This method is used to fetch all the cities .
  public getCities():Observable<any>{

    return this.http.get<any>(this.url.concat('/all'));
  }


//This method is used to delete city. 
public deleteCity(cityId:string): Observable<any>{

  return this.http.delete(this.url.concat('/'+cityId), {responseType : 'text'});
}

}
