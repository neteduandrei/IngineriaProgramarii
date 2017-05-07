
import { Component, OnDestroy } from '@angular/core';
import {MdIconRegistry} from "@angular/material";
import {DomSanitizer} from "@angular/platform-browser";
import {AuthService} from "../../shared/services/auth/auth.service";

@Component({
  selector: 'formy-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.scss'],
  host: {
    'class' : 'page'
  }
})
export class AuthentificationComponent implements  OnDestroy {
  public email : string;
  public password : string;

  public user;
  sub: any;
  constructor(mdIconRegistry: MdIconRegistry, sanitizer: DomSanitizer, private auth : AuthService){
    mdIconRegistry
      .addSvgIcon('facebook',
        sanitizer.bypassSecurityTrustResourceUrl('../assets/images/facebook.svg'));
    mdIconRegistry
      .addSvgIcon('google-plus',
        sanitizer.bypassSecurityTrustResourceUrl('../assets/images/google-plus.svg'));
  }
/*
  signIn(provider){
    this.sub = this._auth.login(provider).subscribe(
      (data) => {
        console.log(data);this.user=data;}
    )
  }
  */
  public manualLogin() {
    this.auth.manualLogin(this.email, this.password)
      .subscribe((response) => console.log(response));
  }
/*
  logout(){
    this._auth.logout().subscribe(
      (data)=>{console.log(data);this.user=null;}
    )
  }
*/
  ngOnDestroy(){
    this.sub.unsubscribe();
  }
}
