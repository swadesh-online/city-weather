import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AddCityWidgetComponent } from '../add-city-widget/add-city-widget.component';

@Component({
  selector: 'app-add-city-modal',
  templateUrl: './add-city-modal.component.html',
  styleUrls: ['./add-city-modal.component.css']
})
export class AddCityModalComponent implements OnInit {
 

  constructor(

    // dialog Reference 
    public dialogRef: MatDialogRef<AddCityWidgetComponent>,
    // injected Data from the dialog box to the component
    @Inject(MAT_DIALOG_DATA) public data: {cityName : string},
  
    ) {}

  ngOnInit(): void {
    
  }

  // On cancelling the dialog, the dialog closes. 
  onNoClick(): void {
    this.dialogRef.close();
  }
}
