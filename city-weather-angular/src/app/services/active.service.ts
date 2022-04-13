import { Injectable } from '@angular/core';
import { ReplaySubject, Subscription } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ActiveService {

  // ReplaySubject: for refreshing of city-preferences component
  refreshPreferencesPage : ReplaySubject<boolean>;
  
  constructor() { 

    this.refreshPreferencesPage = new ReplaySubject(1);
  }
}
