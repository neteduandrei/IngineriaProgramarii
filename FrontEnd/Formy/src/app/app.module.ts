import 'hammerjs';

import {NgModule} from "@angular/core";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthentificationComponent } from './components/authentification/authentification.component';
import { UserFormsComponent } from './components/user-forms/user-forms.component';
import { FillFormComponent } from './components/fill-form/fill-form.component';
import { NavbarComponent } from './shared/components/navbar/navbar.component';



@NgModule({
  declarations: [
    AppComponent,
    AuthentificationComponent,
    UserFormsComponent,
    FillFormComponent,
    NavbarComponent
  ],
  imports: [
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
