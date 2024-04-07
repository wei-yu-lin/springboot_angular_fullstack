import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';

import { VehicleInputComponent } from './vehicle/vehicle-input/vehicle-input.component';
import { VehicleDisplayComponent } from './vehicle/vehicle-display/vehicle-display.component';
import { VehicleEditComponent } from './vehicle/vehicle-edit/vehicle-edit.component';
import { VehicleWrapperComponent } from './vehicle/vehicle-wrapper/vehicle-wrapper.component';
import {yuwei_class_inputComponent} from "./Yuwei/input/yuwei_input.component";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    VehicleInputComponent,
    VehicleDisplayComponent,
    VehicleEditComponent,
    VehicleWrapperComponent,
    yuwei_class_inputComponent,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
