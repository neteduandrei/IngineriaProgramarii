import { Injectable } from '@angular/core';
import {FormReceiveTemplate} from '../../modelsV2/FormReceiveTemplate';

@Injectable()
export class BuildFormService {

  public formReceiveTemplate : FormReceiveTemplate;

  constructor() { }

  public setForm(form : FormReceiveTemplate) {
    this.formReceiveTemplate = form;
  }

  public getFormTemplate() {
    let temp = this.formReceiveTemplate;
    this.formReceiveTemplate = null;
    return temp;
  }
}
