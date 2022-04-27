import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../shared/auth.service';
import { ToastrService } from 'ngx-toastr';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit {
  modifyform!: FormGroup;

  userData: any;
  constructor(private auth: AuthService,
    private Toastr: ToastrService,
    private router: Router,
    private http: HttpClient,) { }

    ngOnInit(): void {

      this.modifyform = new FormGroup({
        user: new FormControl('',[Validators.required,Validators.pattern("[a-zA-Z]+"), Validators.minLength(5)]),
        email: new FormControl('',[Validators.required, Validators.email,Validators.minLength(5) ,Validators.maxLength(255)]),
        pass: new FormControl('',[Validators.required,Validators.minLength(5)]),
        pass2: new FormControl('',[Validators.required,Validators.minLength(5)]),
      });
    }
    modify(){
      let user = this.modifyform.value.user;
      let email = this.modifyform.value.email;
      let pass = this.modifyform.value.pass;
      let pass2 = this.modifyform.value.pass2;
      this.auth.register(user,email,pass,pass2)
      if(pass != pass2){
        alert("A jelszavak nem egyeznek!")
        this.modifyform.reset();
      }else{
        this.auth.register(user,email, pass, pass2)
        .subscribe(
          (res) => {
            alert("Sikeres módosítás");
            this.router.navigate(['main']);
          }, (error) => {
            console.error(error);
            alert("A módosítás sikertelen!");
            this.modifyform.reset();
          })
      }
    }
    
  }
