import { Component, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm, FormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatDividerModule} from '@angular/material/divider';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';

import {FARADAY_STRUCTURE} from '../FARADAY_STRUCTURE';
import {Vehicle} from "../../vehicle/vehicle";

@Component({
  selector: 'yuwei_selector-input',
  templateUrl: './yuwei_input.component.html',
  styleUrls: ['./yuwei_input.component.css'],
  standalone: true,
  imports: [MatFormFieldModule,
            MatInputModule,
            MatSelectModule,
            MatButtonModule,
            MatDividerModule,
            MatIconModule,
            FormsModule,
            MatCardModule,
            MatCheckboxModule,
            MatRadioModule],
})
export class yuwei_class_inputComponent {

  @ViewChild('vehicleForm') yuweiForm!: NgForm;

  @Output() newDataEvent = new EventEmitter();

  constructor(private http: HttpClient) {}



  test(): void {

    const userInstance: FARADAY_STRUCTURE = new FARADAY_STRUCTURE(this.yuweiForm.value.brand, this.yuweiForm.value.model, this.yuweiForm.value.year);
    console.log(userInstance);



    this.http.post<FARADAY_STRUCTURE>(
      "http://localhost:2408/yuwei/post",
      userInstance
    ).subscribe(data=>{
      console.log(data);
    });
  }


}
