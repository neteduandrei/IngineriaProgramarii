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
    field1.title = "I am short text";
    field1.description = "I am a short text description";
    field1.type = "shortText";
    field1.required = true;
    field1.options = {
      regex: '(yes)|(no)'
    };

    let field2 = new Field();
    field2.title = "I am long text";
    field2.description = "I am a long text description";
    field2.type = "longText";
    field2.required = false;
    field2.options = {
      maxLength: 128
    };

    let field3 = new Field();
    field3.title = "I am radiobutton";
    field3.description = "I am a radiobutton description";
    field3.type = "singleChoice";
    field3.required = false;
    field3.value = ['Option 1', 'Option 2', 'Option 3'];


    let field4 = new Field();
    field4.title = "I am checkbox";
    field4.description = "I am a checkbox description";
    field4.type = "multipleChoice";
    field4.required = false;
    field4.value = ['Option 1', 'Option 2', 'Option 3'];

    let field5 = new Field();
    field5.title = "I am Date";
    field5.description = "I am a Date description";
    field5.type = "date";
    field5.required = false;

    let field6 = new Field();
    field6.title = "I am linear scale";
    field6.description = "I am a linear scale description";
    field6.type = "linearScale";
    field6.required = false;
    field6.value = {
      min : 0,
      max : 8
    };

    this.formTemplateToFill.form.fields.push(field1);
    this.formTemplateToFill.form.fields.push(field2);
    this.formTemplateToFill.form.fields.push(field3);
    this.formTemplateToFill.form.fields.push(field4);
    this.formTemplateToFill.form.fields.push(field5);
    this.formTemplateToFill.form.fields.push(field6);
    return Observable.of(this.formTemplateToFill);
  }

}
