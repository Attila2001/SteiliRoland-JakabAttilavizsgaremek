import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../shared/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm !: FormGroup;
  constructor(
    private auth: AuthService,
    private formBuilder: FormBuilder,
    private router: Router
    ) { }

  ngOnInit(): void {
this.loginForm = new FormGroup({
  user: new FormControl('',Validators.required),
  pass: new FormControl('',Validators.required),
});
  }
  login(){
    let user = this.loginForm.value.user;
    let pass = this.loginForm.value.pass;
    console.log(user,pass);
    this.auth.login(user,pass)
    .subscribe(res =>{
      console.log(res.token);
      
        localStorage.setItem('currentuser', 
        JSON.stringify({token: res.token, name: res.name})
        );
        this.router.navigate(['main']);
      }
    );
  }
}