import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AddCityModalComponent } from '../add-city-modal/add-city-modal.component';
import { ActiveService } from '../../services/active.service';
import { CityService } from '../../services/city.service';

@Component({
  selector: 'app-add-city-widget',
  templateUrl: './add-city-widget.component.html',
  styleUrls: ['./add-city-widget.component.css']
})

export class AddCityWidgetComponent implements OnInit {
  
  // cityName is initialized, storing the name of city to be added. 
  cityName : string='';

  constructor(public dialog: MatDialog,
              private cityServ : CityService,
              public toaster : ToastrService,
              private activeServ : ActiveService,
              private route : Router) { }

  ngOnInit(): void {

  }


  openDialog(): void {
    
    //on dialog opening and typing, data is transmitted to cityName var. 
    const dialogRef = this.dialog.open(AddCityModalComponent, {
      width: '300px',
      data: {cityName: this.cityName},
    });


    // on dialog close with selection of OK, 
    // API is called and the city is added to the db.
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.cityName = result;
      this.addCity(this.cityName);
      console.log(this.cityName);
      this.cityName = '';
      
    });
}

 // This method is used to add city to the List.
 public addCity(cityName:any){

  //check for blank values in cityName , else calling the service to add City. 
  if(cityName!='' && cityName!=undefined && cityName!=null){


   this.cityServ.addCity(cityName).subscribe(resp=>{
    
    //if resp is Success, the page is refreshed to fetch the updated city list.
    if(resp == 'SUCCESS'){
   
      this.activeServ.refreshPreferencesPage.next(true);
      this.toaster.success("The city is successfully added","Success");
  
    }
  },
      error => {
        
        //Any error occured, the message is being displayed through Toaster.
        var err = JSON.parse(error.error);
        this.toaster.error(err.message,"Error")})

      }
}

}
