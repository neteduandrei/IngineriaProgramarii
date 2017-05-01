import { Injectable } from '@angular/core';
import {FormTemplateToFill} from "../../models/FormTemplateToFill";
import {Form} from "../../models/Form";
import {Observable} from "rxjs/Observable";
import {Field} from "../../models/Field";

@Injectable()
export class FillFormService {

  private formTemplateToFill : FormTemplateToFill;

  constructor() {
    this.formTemplateToFill = new FormTemplateToFill();
    this.formTemplateToFill.form = new Form();
    this.formTemplateToFill.form.fields = [];
  }

  public getForm(id : string) : Observable<FormTemplateToFill> {
    this.formTemplateToFill.id = id;
    this.formTemplateToFill.form.title = 'Form from server';
    this.formTemplateToFill.form.description = 'Description from server';

    let field1 = new Field();
    field1.title = "I am a title";
    field1.description = "I am a description";
    field1.type = "shortText";
    field1.required = true;
    field1.options = {
      regex: '(yes)|(no)'
    };

    this.formTemplateToFill.form.fields.push(field1);
    return Observable.of(this.formTemplateToFill);
  }

}
