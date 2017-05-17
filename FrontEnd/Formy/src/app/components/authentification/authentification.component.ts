
import {Component, OnDestroy, OnInit} from '@angular/core';
import {MdIconRegistry} from "@angular/material";
import {DomSanitizer} from "@angular/platform-browser";
import {AuthService} from "../../shared/services/auth/auth.service";
import {Router} from '@angular/router';

@Component({
  selector: 'formy-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.scss'],
  host: {
    'class' : 'page'
  }
})
export class AuthentificationComponent implements OnInit, OnDestroy {
  public email : string;
  public password : string;
  public register_name : string;
  public register_username : string;
  public register_email : string;
  public register_password : string;

  public error_message : string;
  public error_register : string;


  public user;
  sub: any;
  constructor(mdIconRegistry: MdIconRegistry, sanitizer: DomSanitizer, private auth : AuthService, private router : Router){
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

  ngOnInit() {
    console.log(AuthService.getLoginStatus());
    if(AuthService.getLoginStatus() === true) {
      this.router.navigate(['/user']);
    }
  }

  public manualLogin() {

    this.auth.manualLogin(this.email, this.password)
      .subscribe(
        (data) => {
          console.log("succes");
          this.error_message = "";
          this.router.navigate(['/user']);
        },
        (err) => {
          console.log(err);
          this.error_message = err._body || 'There was a problem on the server';
        });

  }
  public registerUser(){
    this.auth.registerUser(this.register_name, this.register_username,this.register_email,this.register_password)
      .subscribe(
        (response) => {
          this.error_register = "";
          this.router.navigate(['/user']);
        },
        (err) => {
          console.log(err);
          this.error_register = err._body || 'There was a problem on the server';
        }
      );
  }
  /*
   logout(){
   this._auth.logout().subscribe(
   (data)=>{console.log(data);this.user=null;}
   )
   }
   */
  ngOnDestroy(){
    //this.sub.unsubscribe();
  }
}
