import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CityPreferencesComponent } from './city-preferences.component';

describe('WeatherDetailsComponent', () => {
  let component: CityPreferencesComponent;
  let fixture: ComponentFixture<CityPreferencesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CityPreferencesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CityPreferencesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
