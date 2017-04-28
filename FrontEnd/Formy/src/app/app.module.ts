import 'hammerjs';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MaterialModule } from "@angular/material";
import { FlexLayoutModule } from "@angular/flex-layout";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthentificationComponent } from './components/authentification/authentification.component';
import { UserFormsComponent } from './components/user-forms/user-forms.component';
import { BuildFormComponent } from './components/build-form/build-form.component';
import { FillFormComponent } from './components/fill-form/fill-form.component';
import { NavbarComponent } from './shared/components/navbar/navbar.component';


@NgModule({
  declarations: [
    AppComponent,
    AuthentificationComponent,
    UserFormsComponent,
    BuildFormComponent,
    FillFormComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    MaterialModule,
    FlexLayoutModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
