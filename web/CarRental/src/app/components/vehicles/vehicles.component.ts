import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../../shared/interfaces/vehicle';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthGuard } from '../../shared/auth.guard';
import { AuthService } from '../../shared/auth.service';
import { carModel } from '../../models/car.model';
import { ApiService } from '../../shared/api.service';
@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {
  host = 'http://localhost:8000/api/';
  vehicleForm !: FormGroup;
  vehicleList:Vehicle[] = [];
  token !: string|null;
  car = new carModel();



  constructor(
    private http: HttpClient,
    private authGuard: AuthGuard,
    private auth: AuthService,
    private api: ApiService) 
    
    { }

  ngOnInit(): void {
    this.fetchData();
    this.vehicleForm = new FormGroup({
      plate: new FormControl('',Validators.required),
      doornumber: new FormControl('',Validators.required),
      year: new FormControl('',Validators.required),
      propulsion: new FormControl('',Validators.required),
      gearbox: new FormControl('',Validators.required),
      brand: new FormControl('',Validators.required),
      color: new FormControl('',Validators.required),
    });
  }
  fetchData(){
    let url = "http://localhost:8000/api/"
    this.http.get<any>(url).subscribe(
      res => {
        this.vehicleList = res;
      });
  }
  newCar(){
    
    let carData = {
      plate: this.vehicleForm.value.plate,
      doornumber: this.vehicleForm.value.doornumber,
      modelyear: this.vehicleForm.value.modelyear,
      propulsion: this.vehicleForm.value.propulsion,
      gearbox: this.vehicleForm.value.gearbox,
      brand: this.vehicleForm.value.brand,
      color: this.vehicleForm.value.color,
    }
    
    let token = this.auth.isLoggedIn();
    console.log(token);
    
    let data = JSON.stringify(carData);
    let headerObj = new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization': `Bearer ${token}`
    })
    let header = {
      headers: headerObj
    }

    let endpoint = 'cars';
    let url = this.host + endpoint;
    return this.http.post<any>(url,data,header)

    
  }


}
