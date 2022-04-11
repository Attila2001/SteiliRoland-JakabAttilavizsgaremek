import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  api:string = 'http://localhost:8000/api/'
  constructor(private http: HttpClient,private router: Router) {}
  login(user:string,pass:string){
    let endpoint = 'login';
    let url = this.api + endpoint;
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
  register(user:string,email:string,pass:string,pass2:string){
    let endpoint = 'register';
    let url = this.api + endpoint;
    let authData = {

      name: user,
      email: email,
      password: pass,
      password_confirmation: pass2
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

  logout(){
    if(localStorage.getItem('currentUser') === null){
      return;
    }
    let data:any = localStorage.getItem('currentUser');
    localStorage.removeItem('currentUser');
    let currentUser = JSON.parse(data);
    let token = currentUser.token;

    let headerObj = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + token
    });
    let httpOption = {
      headers: headerObj
    };
    let endpoint = 'logout';
    let url = this.api + endpoint;

    return this.http.post<any>(url, '', httpOption)
    .subscribe(res => {
      console.log(res);
      this.router.navigate(['']);
    })
  }
}

