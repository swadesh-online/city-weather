import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCityWidgetComponent } from './add-city-widget.component';

describe('AddCityWidgetComponent', () => {
  let component: AddCityWidgetComponent;
  let fixture: ComponentFixture<AddCityWidgetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCityWidgetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCityWidgetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
