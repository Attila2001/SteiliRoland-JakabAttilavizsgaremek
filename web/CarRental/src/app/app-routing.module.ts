import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardsComponent } from './components/cards/cards.component';
import { NewcardComponent } from './components/cards/newcard/newcard.component';
import { OldcardComponent } from './components/cards/oldcard/oldcard.component';
import { CarsComponent } from './components/cars/cars.component';
import { LoginComponent } from './components/login/login.component';
import { MainComponent } from './components/main/main.component';
import { RegisterComponent } from './components/register/register.component';
import { SettingsComponent } from './components/settings/settings.component';
import { VehiclesComponent } from './components/vehicles/vehicles.component';
import { ProfilComponent } from './components/profil/profil.component';

const routes: Routes = [
  {path: 'profil', component: ProfilComponent},
  {path: 'settings', component: SettingsComponent},
  {path: 'cards', component: CardsComponent},
  {path: 'oldcard', component: OldcardComponent},
  {path: 'newcard', component: NewcardComponent},
  {path: 'vehicles', component: VehiclesComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'cars', component: CarsComponent},
  {path: 'main', component: MainComponent},
  {path: '', redirectTo: 'main', pathMatch: 'full' },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
