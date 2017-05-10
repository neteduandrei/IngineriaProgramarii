import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions} from "@angular/http";

import { baseUrl } from '../../globals';

@Injectable()
export class AuthService {

  private url = `${baseUrl}/v1/authentication/login`;

  private loginStatus : boolean = false;

  constructor(private http : Http) { }

  public manualLogin(email : string, password : string) {
    let headers = new Headers({'Content-Type' : 'application/json'});
    let options = new RequestOptions({headers : headers, withCredentials : true});
    return this.http.post(this.url, {email: email, password: password}, options)
      ._do((response) => {
        this.loginStatus = response.status == 200;
      });

  }

  public registerUser(name : string, username : string, email : string, password : string) {
    let headers = new Headers({'Content-Type' : 'application/json'});
    let options = new RequestOptions({headers : headers, withCredentials : true});
    return this.http.post(`${baseUrl}/v1/authentication/signup`, {name: name, nickname: username, email: email, password: password}, options);
  }

  public getLoginStatus() {
    return this.loginStatus === true;
  }
}
