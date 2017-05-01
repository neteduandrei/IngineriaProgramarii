import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MaterialModule } from "@angular/material";
import { FlexLayoutModule } from "@angular/flex-layout";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

import { BuildFormComponent } from "./components/build-form/build-form.component";
import { EditPasswordComponent } from "./components/edit-password/edit-password.component";
import { UserFormsComponent } from "./components/user-forms/user-forms.component";
import { DialogDeleteComponent } from "./components/edit-password/edit-password.component";
import { AuthentificationComponent } from "./components/authentification/authentification.component";

const routes: Routes = [
  {
    path: '',
    pathMatch : 'full',
    redirectTo: 'authentification'
  },
  {
    path: 'build-form',
    component: BuildFormComponent
  },
  {
    path: 'user',
    component: UserFormsComponent
  },
  {
    path: 'edit-password',
    component: EditPasswordComponent
  },
  {
    path: 'dialog-delete',
    component: DialogDeleteComponent
  },
  {
    path: 'authentification',
    component: AuthentificationComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    MaterialModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    HttpModule,
    FormsModule,
    BrowserModule
  ],
  exports: [
    RouterModule,
    MaterialModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    HttpModule,
    FormsModule,
    BrowserModule
  ],
  declarations: [
  ]
})
export class AppRoutingModule { }
