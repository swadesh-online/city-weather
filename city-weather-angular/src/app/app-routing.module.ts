import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CityPreferencesComponent } from './components/city-preferences/city-preferences.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {path : 'preferences', component : CityPreferencesComponent},
  { path: '',   redirectTo: '/preferences', pathMatch: 'full' }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
