/*
* File: register.component.ts
* Author: Madarász Dávid
* Copyright: 2022, Madarász Dávid
* Group: Szoft II/N
* Date: 2022-02-24
* Github: https://github.com/afriyy/
* Licenc: GNU GPL
*/

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm !: FormGroup;
  constructor(
    private auth: AuthService,
    private formBuilder: FormBuilder,
    private router: Router
    ) { }

  ngOnInit(): void {
this.registerForm = new FormGroup({
  user: new FormControl('',Validators.required),
  email: new FormControl('',Validators.required),
  pass: new FormControl('',Validators.required),
});
  }
  register(){
    let user = this.registerForm.value.user;
    let email = this.registerForm.value.email;
    let pass = this.registerForm.value.pass;
    this.auth.register(user,email,pass)
    .subscribe((res: { success: any; data: { token: any; name: any; }; }) =>{
      if (res.success) {
        console.log(res.success);
        localStorage.setItem('currentUser', 
        JSON.stringify({token: res.data.token, name: res.data.name})
        );
        this.router.navigate(['vehicles']);
      }else{
        alert("A belépés sikertelen!");
      }
    });
  }
}
