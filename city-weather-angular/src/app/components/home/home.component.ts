import { AfterViewInit, Component, ElementRef, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { WeatherService } from '../../services/weather.service';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  // to store the cityId of the city details to be displayed.  
  public cityId!: string;
  
  // to store the Detailed Weather Report of the city. 
  public cityWeatherDetails : any;

  // to store the next 5 hours weather update of the city. 
  public next5HoursUpdate : Array<any>;
  
  // to store the forecast weather data of the city. 
  public forecastData : Array<any>;
    
  // to compute and store the UV Status, according to UV-Index. 
  public uvStatus : string;
    

  constructor(private elementRef: ElementRef,
                private activeRoute: ActivatedRoute,
                private router : Router,
                private weatherService : WeatherService,
                private toaster : ToastrService) {
                  
                  //initialization of variables. 
                  this.next5HoursUpdate = [];
                  this.forecastData = [];
                  this.uvStatus = '';

      //check if city Id is present, else navigate back to preferences for city selection.              
      this.activeRoute.queryParams.subscribe(params => {
          console.log(params);
          if(params['cityId'] != undefined){
          
            this.cityId = params['cityId'];
          }else{

            this.router.navigate(['/preferences']);
            this.toaster.error("Please select the desired city from Preferences.");
          }
      });
  }
  
  ngOnInit(): void {

  if(this.cityId!= undefined){
 
    // if cityId is available, fetch the detailed weather report. 
    this.weatherService.getWeatherReport(this.cityId).subscribe(resp=>{
      this.cityWeatherDetails = resp;    

      //compute and set next 5 hours weather update. 
      this.getNext5HoursUpdate(this.cityWeatherDetails);

      // store the forecastData to be iterated. 
      this.forecastData = this.cityWeatherDetails?.forecast?.forecastday;
      
      //compute and get the UV status from uv-index
      this.getUvStatus(this.cityWeatherDetails?.current?.uv);

    },error=>{
      console.log(error);
      this.toaster.error("Something went wrong","Error");

    });
  }else{
    this.toaster.error("Please select the desired city from Preferences.","Error");
  }
  }
  

  // compute according to localtime and report next 5 hours update. 
 getNext5HoursUpdate(this: any, cityWeatherDetails: any) {
 var currentLocalTime = cityWeatherDetails?.location?.localtimeEpoch;
  var hourlyWeatherArr = cityWeatherDetails?.forecast?.forecastday[0]?.hour;
  for(let hour of hourlyWeatherArr){
    if(currentLocalTime<hour?.timeEpoch && this.next5HoursUpdate.length <5){
      this.next5HoursUpdate.push(hour);
    }
  }

console.log("next 5 hours update : ", this.next5HoursUpdate)
}


// take in uv-index and setting uvStatus accordingly
getUvStatus(uv: any) {
 if(uv <= 2){
   this.uvStatus = 'Low';
 }else if(uv > 2 && uv <= 5){
   this.uvStatus = 'Moderate';
 }else if(uv > 5 && uv <=10){
   this.uvStatus = 'High';
 }else if(uv >10) {
   this.uvStatus = 'Extreme';
 }
}
}
