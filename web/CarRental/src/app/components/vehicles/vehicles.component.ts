import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../../services/interfaces/vehicle';
import { FormBuilder, FormControl, FormGroup, FormsModule, Validators } from '@angular/forms';
import { AuthGuard } from '../../services/auth.guard';
import { AuthService } from '../../services/auth.service';
@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {
  vehicleForm !: FormGroup;
  vehicleList:Vehicle[] = [];
  token !: string|null;
  constructor(
    private http: HttpClient,
    private formBuilder: FormBuilder,
    private auth: AuthService) 
    { }

  ngOnInit(): void {
    this.fetchData();
    this.vehicleForm = new FormGroup({
      plate: new FormControl('',Validators.required),
      brand: new FormControl('',Validators.required),
      year: new FormControl('',Validators.required),
      price: new FormControl('',Validators.required),
    });
  }
  fetchData(){
    let url = "http://localhost:8000/api/vehicles"
    this.http.get<any>(url).subscribe(
      res => {
        this.vehicleList = res;
      });
  }
  newCar(){
    let url = "http://localhost:8000/api/CarRent";
    let carData = {
      plate: this.vehicleForm.value.plate,
      brand: this.vehicleForm.value.brand,
      year: this.vehicleForm.value.year,
      price: this.vehicleForm.value.price,
    }
    console.log(
      carData.brand+
      carData.plate
      );
    
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
    this.http.post<any>(url,data,header).subscribe(res=>{
      console.log(res);
    });
  }
}
