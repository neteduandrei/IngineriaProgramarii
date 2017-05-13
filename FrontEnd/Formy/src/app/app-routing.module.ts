import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MaterialModule } from "@angular/material";
import { FlexLayoutModule } from "@angular/flex-layout";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { Angular2SocialLoginModule } from "angular2-social-login";


import { BuildFormComponent } from "./components/build-form/build-form.component";
import { EditPasswordComponent } from "./components/edit-password/edit-password.component";
import { UserFormsComponent } from "./components/user-forms/user-forms.component";
import { DialogShareComponent } from "./components/user-forms/form-preview/dialogs/dialog-share.component"
import { DialogDeleteComponent } from "./components/edit-password/edit-password.component";
import { AuthentificationComponent } from "./components/authentification/authentification.component";
import {FillFormComponent} from "app/components/fill-form/fill-form.component";
import { EditProfileComponent } from "./components/edit-profile/edit-profile.component";
import {AnswersFormComponent} from "./components/answers-form/answers-form.component";


let providers = {
    "google": {
      "clientId": "GOOGLE_CLIENT_ID"
    },
    "facebook": {
      "clientId": "FACEBOOK_CLIENT_ID",
      "apiVersion": "v2.4"
    }
  };
const routes: Routes = [
  {
    path: '',
    component: AuthentificationComponent
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
    path: 'form/fill/:id',
    component: FillFormComponent
  },
  {
    path: 'form/answers',
    component: AnswersFormComponent
  },
  {
    path: 'dialogDelete',
    component: DialogDeleteComponent
  },
  {
    path: 'dialogShare',
    component: DialogShareComponent
  },
  {
    path: 'editProfile',
    component: EditProfileComponent
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
    BrowserModule,
    Angular2SocialLoginModule
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

Angular2SocialLoginModule.loadProvidersScripts(providers);
