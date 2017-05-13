import { Injectable } from '@angular/core';
import {FormTemplateReceive} from '../../modelsV2/FormTemplateReceive';

@Injectable()
export class BuildFormService {

  public formTemplateReceive : FormTemplateReceive;

  constructor() { }

  public setForm(form : FormTemplateReceive) {
    this.formTemplateReceive = form;
    console.log(this.formTemplateReceive);
  }

  public getFormTemplate() {
    return this.formTemplateReceive;
  }
}
