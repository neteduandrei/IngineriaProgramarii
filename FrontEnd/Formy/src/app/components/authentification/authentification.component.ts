
import { Component, OnDestroy } from '@angular/core';
import { AuthService } from "angular2-social-login";
import {MdIconRegistry} from "@angular/material";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'formy-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.scss'],
  host: {
    'class' : 'page'
  }
})
export class AuthentificationComponent implements  OnDestroy {
  public user;
  sub: any;
  constructor(public _auth: AuthService, mdIconRegistry: MdIconRegistry, sanitizer: DomSanitizer){
    mdIconRegistry
      .addSvgIcon('facebook',
        sanitizer.bypassSecurityTrustResourceUrl('../assets/images/facebook.svg'));
    mdIconRegistry
      .addSvgIcon('google-plus',
        sanitizer.bypassSecurityTrustResourceUrl('../assets/images/google-plus.svg'));
  }

  signIn(provider){
    this.sub = this._auth.login(provider).subscribe(
      (data) => {
        console.log(data);this.user=data;}
    )
  }

  logout(){
    this._auth.logout().subscribe(
      (data)=>{console.log(data);this.user=null;}
    )
  }

  ngOnDestroy(){
    this.sub.unsubscribe();
  }
}
