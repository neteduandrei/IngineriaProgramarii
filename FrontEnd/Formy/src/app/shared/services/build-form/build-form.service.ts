import { Injectable } from '@angular/core';
import {Http, RequestOptions, Headers} from "@angular/http";
import {FormTemplateGenerator} from "../../models/FormTemplateGenerator";

import { baseUrl } from '../../globals';

@Injectable()
export class BuildFormService {

  private url = `${baseUrl}/v1/forms`;

  constructor(private http : Http) { }

  sendForm(form : FormTemplateGenerator) {
    let headers = new Headers({'Content-Type' :'application/json'});
    let options = new RequestOptions({ headers: headers, withCredentials: true });

    return this.http.post(this.url, form, options);
  }


}
