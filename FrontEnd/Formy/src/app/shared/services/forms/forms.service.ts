import { Injectable } from '@angular/core';

import {baseUrl} from '../../globals';
import {Http, RequestOptions, Headers} from '@angular/http';
import {Form} from '../../models/Form';
import {FormReceiveTemplate} from '../../modelsV2/FormReceiveTemplate';

@Injectable()
export class FormsService {

  private url = `${baseUrl}/v1/forms`;

  constructor(private http : Http) { }

  public getAllForms() {
    let options = new RequestOptions({withCredentials : true});
    return this.http.get(this.url, options)
      .map(response => response.json());
  }

  public sendForm(form : Form) {
    let headers = new Headers({'Content-Type' : 'application/json'});
    let options = new RequestOptions({headers : headers, withCredentials : true});
    return this.http.post(this.url, form, options);
  }

  public downloadFile(id : string) {
    window.open(`${baseUrl}/v1/download/${id}`);
  }

  public getFromById(id : string) {
    return this.http.get(`${this.url}/${id}`, {withCredentials: true})
      .map(response => response.json());
  }

  public update(form : FormReceiveTemplate) {
    let headers = new Headers({'Content-Type' : 'application/json'});
    let options = new RequestOptions({headers : headers, withCredentials : true});
    return this.http.put(this.url, form, options)
      .map(response => response.json());
  }

}

