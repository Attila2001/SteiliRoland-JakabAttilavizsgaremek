import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  host = 'http://localhost:8000/api/';

  constructor(private http: HttpClient) { }

  addcars(data: any) {
    let dataStore:any = localStorage.getItem('currentUser');
    let currentUser = JSON.parse(dataStore);
    let token = currentUser.token;     
  
    console.log("felhasználó: " + currentUser.name);
    console.log(data);

    let headerObj = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + token
    });
    const httpOption = {
      headers: headerObj
    };

  

    let endpoint = 'cars';
    return this.http.post<any>(this.host + endpoint, data, httpOption)
    .pipe(map(  (res:any) => {
      return res;
    }))
  }

  getcars() {
    let endpoint = 'cars';
    return this.http.get<any>(this.host + endpoint)
    .pipe(map((res:any) => {
      return res;
    }))
  }

  getGroupcars(id: number) {
    let endpoint = 'cars/groups/';
    return this.http.get<any>(this.host + endpoint + id);
  }

  deletecars(id: number) {
    let data:any = localStorage.getItem('currentUser');
    let currentUser = JSON.parse(data);
    let token = currentUser.token;    
    let headerObj = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + token
    });
    const httpOption = {
      headers: headerObj
    };

    let endpoint = 'cars/';
    return this.http.delete<any>(this.host + endpoint + id, httpOption)
    .pipe(map( res => {
      return res;
    }))
  }
  updatecars(car: any, id: number) {
    let data:any = localStorage.getItem('currentUser');
    let currentUser = JSON.parse(data);
    let token = currentUser.token;    

    let headerObj = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + token
    });
    const httpOption = {
      headers: headerObj
    };
    console.log('kocsi frissíétse');
    let endpoint = 'cars/';
    return this.http.put<any>(this.host + endpoint + id, car, httpOption)
    .pipe(map( res => {
      return res;
    }))
    
  }
}
