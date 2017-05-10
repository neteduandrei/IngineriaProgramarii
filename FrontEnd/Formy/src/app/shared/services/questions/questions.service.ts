import { Injectable } from '@angular/core';
import { baseUrl } from '../../globals';
import {Http, RequestOptions, Headers} from '@angular/http';

@Injectable()
export class QuestionsService {

  private url = `${baseUrl}/v1/responses`;

  constructor(private http : Http) { }

  public sendQuestion(res : any) {
    let headers = new Headers({'Content-Type' : 'application/json'});
    let options = new RequestOptions({headers : headers, withCredentials : true});
    return this.http.post(this.url, res, options);
  }

}
