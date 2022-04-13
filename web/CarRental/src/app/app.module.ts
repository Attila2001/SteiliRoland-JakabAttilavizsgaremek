import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from'@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { VehiclesComponent } from './components/vehicles/vehicles.component';
import { ToastrModule } from 'ngx-toastr';
import { CardsComponent } from './components/cards/cards.component';
import { CarsComponent } from './components/cars/cars.component';
import { MainComponent } from './components/main/main.component';
import { OldcardComponent } from './components/cards/oldcard/oldcard.component';
import { NewcardComponent } from './components/cards/newcard/newcard.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    VehiclesComponent,
    CardsComponent,
    CarsComponent,
    MainComponent,
    OldcardComponent,
    NewcardComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
