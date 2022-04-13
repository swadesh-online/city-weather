import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { CityPreferencesComponent } from './components/city-preferences/city-preferences.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { ToastrModule } from 'ngx-toastr';
import { AddCityWidgetComponent } from './components/add-city-widget/add-city-widget.component';
import { AddCityModalComponent } from './components/add-city-modal/add-city-modal.component';
import { MatDialogModule } from '@angular/material/dialog';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    CityPreferencesComponent,
    NavBarComponent,
    AddCityWidgetComponent,
    AddCityModalComponent,
    HomeComponent,
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
  ToastrModule.forRoot({positionClass: 'toast-bottom-center',
    preventDuplicates: true,}),
    MatDialogModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
