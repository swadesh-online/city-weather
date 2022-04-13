import { AfterViewInit, Component, ElementRef, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Subscription } from 'rxjs';
import { CityWeatherReport } from '../../model/CityWeatherReport';
import { ActiveService } from '../../services/active.service';
import { CityService } from '../../services/city.service';
import { WeatherService } from '../../services/weather.service';

@Component({
  selector: 'app-city-preferences',
  templateUrl: './city-preferences.component.html',
  styleUrls: ['./city-preferences.component.css']
})
export class CityPreferencesComponent implements OnInit {
  // weatherReports - contains the array of CityWeatherReports to be displayed
  weatherReports : CityWeatherReport[];
  
  //pageLoaded - checks if the page is loaded with the cards, then display 
  pageLoaded : boolean;

  //Subscription to fetch updated reports on addition/deletion of cities. 
  subscription1!: Subscription;

  constructor(private elementRef: ElementRef,
    private weatherServ : WeatherService,
    private toaster : ToastrService,
    private activeServ : ActiveService,
    private cityServ : CityService,
    private route : Router) { 
    
    //Initializing the variables. 
    this.pageLoaded = false;
    this.weatherReports = [{
      id: "",
      city : "",
      condition : "",
      localTime : "",
      maxTemperature : "",
      minTemperature : "",
      imageUrl : ""
    }]

  }

  ngOnInit(): void {
    //On the page load, the reports are being fetched from the backend.
   this.activeServ.refreshPreferencesPage.next(true);
   
   //subscription to fetch updated reports, on deletion/addition of cities.
   this.subscription1 = this.activeServ.refreshPreferencesPage.subscribe(resp=>{
      if(resp==true){
        this.getReports();
        this.activeServ.refreshPreferencesPage.next(false);
      }
    })
  }

  //fetch all Reports from the backend. 
  public getReports(){
   
    //calling the service to fetch the weatherReports 
    this.weatherServ.getWeatherReports().subscribe(
      resp=>{ 
        
        this.weatherReports= resp;
        
        //as the reports are available, setting pageLoaded to true. 
        this.pageLoaded = true;
      },
      error=>{

        //Any error occured during fetching of reports, this toaster message will be displayed. 
        this.toaster.error(
          "It's not you. It's us.","Oops"
        )}
      );
  }


  //This method is used to delete a city from the list
  public deleteCity(cityId:any){
    
    //confirmation to double check 
    if(confirm("Are you sure you want to delete?")){
  
      //calling the services to delete city from the list. 
      this.cityServ.deleteCity(cityId).subscribe(resp=>{
      
        //if resp is success, success toaster is diplayed , else display error message.
        if(resp == 'SUCCESS'){
        this.toaster.success("Deleted successfully", "Success");
        this.activeServ.refreshPreferencesPage.next(true);
      }
    }, error=> {
      this.toaster.error("Oops something went wrong","Error");

    })
  }
  }

  //On clicking Info button , navigation to homepage with queryparam as cityId
  public openDetailedHomePage(cityId:any){ 
    let navigationExtras: NavigationExtras = {
      queryParams: {
          cityId: cityId
      }
  }
    this.route.navigate(['/home'], navigationExtras);

  }


  //Unsubscribing the subscription on the destruction. 
  ngOnDestroy(){
    this.subscription1.unsubscribe();
  }
}
