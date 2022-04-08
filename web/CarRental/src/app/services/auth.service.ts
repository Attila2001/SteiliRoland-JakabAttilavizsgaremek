import { Injectable } from '@angular/core';
import { LoginComponent } from '../components/login/login.component';
import { RegisterComponent } from '../components/register/register.component';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  host = 'http://localhost:8000/api/carrent'
  constructor(private http: HttpClient) {}
  login(user:string,pass:string){
    let endpoint = 'login';
    let url = this.host + endpoint;
    let authData = {
      name: user,
      password: pass
    }
    let data = JSON.stringify(authData);
    let headerObj = new HttpHeaders({
      'Content-Type':'application/json'
    })
    let header = {
      headers: headerObj
    }
      return this.http.post<any>(url,data,header);
  }
  register(user:string,email:string,pass:string){
    let endpoint = 'register';
    let url = this.host + endpoint;
    let authData = {

      name: user,
      email: email,
      password: pass,
      password_confirmation: pass
    }
    let data = JSON.stringify(authData);
    let headerObj = new HttpHeaders({
      'Content-Type':'application/json'
    })
    let header = {
      headers: headerObj
    }
      return this.http.post<any>(url,data,header);
  }
  isLoggedIn() {
    if (localStorage.getItem('currentUser') === null) {
      return false;
    }
    let data:any = localStorage.getItem('currentUser');
    let currentUser = JSON.parse(data);
    let token = currentUser.token;
    return token;
  }
}
