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
  pass2: new FormControl('',Validators.required),
});
  }
  register(){
    let user = this.registerForm.value.user;
    let email = this.registerForm.value.email;
    let pass = this.registerForm.value.pass;
    let pass2 = this.registerForm.value.pass2;
    this.auth.register(user,email,pass,pass2)
    if(pass != pass2){
      alert("A jelszavak nem egyeznek!")
      this.registerForm.reset();
    }else{
      this.auth.register(user,email, pass, pass2,)
      .subscribe(
        (res) => {
          alert("Sikeres regisztráció!");
          this.router.navigate(['']);
        }, (error) => {
          console.error(error);
          alert("A regisztráció sikertelen!");
          this.registerForm.reset();
        })
    }
  }
}
