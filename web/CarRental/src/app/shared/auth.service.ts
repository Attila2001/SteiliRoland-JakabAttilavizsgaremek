import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  host = 'http://localhost:8000/api/';
  constructor(
    private http: HttpClient,
    private router: Router
    ) { }

  login(user: string, pass: string) {

    let authData = {
      name: user,
      password: pass
    }
    let data = JSON.stringify(authData);
    let headerObj = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    let httpOption = {
      headers: headerObj
    };
    let endpoint = 'login';
    let url = this.host + endpoint;

    return this.http.post<any>(url, data, httpOption)
    .pipe(map( (res:any) => {
      return res;
    }))
  }
  logout() {
    if (localStorage.getItem('currentUser') === null) {
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
    let url = this.host + endpoint;
    return this.http.post<any>(url, '', httpOption)
    .subscribe(res => {
      console.log(res);
      this.router.navigate(['']);
    })
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
  register(user:string,email:string,pass:string,pass2:string){
    let authData = {

      name: user,
      email: email,
      password: pass,
      confirmed_password: pass2
    }
    let data = JSON.stringify(authData);
    let headerObj = new HttpHeaders({
      'Content-Type':'application/json'
    })
    let header = {
      headers: headerObj
    }
    let endpoint = 'register';
    let url = this.host + endpoint;
      return this.http.post<any>(url,data,header);
  }

  rent(firstname:string,lastname:string ,username:string,email:string,address:string){
    let authData = {

      firstname:firstname,
      lastname: lastname,
      name: username,
      email: email,
      address:address,
    }
    let data = JSON.stringify(authData);
    let headerObj = new HttpHeaders({
      'Content-Type':'application/json'
    })
    let header = {
      headers: headerObj
    }
    let endpoint = 'renters';
    let url = this.host + endpoint;
      return this.http.post<any>(url,data,header);
  }

}
