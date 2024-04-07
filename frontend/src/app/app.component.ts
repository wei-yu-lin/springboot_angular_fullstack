import { Component } from "@angular/core";
import { HttpClient } from '@angular/common/http';

import {Vehicle} from './vehicle/vehicle';


//app.component網頁的javascript

@Component({
  selector: "app-component",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {

  vehicles: Vehicle[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<Vehicle[]>(
      "http://localhost:2408/vehicles"
    ).subscribe(data => this.vehicles = data);
  }

  appendData(newVehicle: any): void {
    this.vehicles.push(newVehicle);
  }

  removeItem(vehicleId: number): void {
    this.http.delete(
      "http://localhost:2408/vehicles/" + vehicleId,
    ).subscribe(data => this.vehicles = this.vehicles.filter((vehicle: Vehicle) => vehicle.id != vehicleId));
  }

}
