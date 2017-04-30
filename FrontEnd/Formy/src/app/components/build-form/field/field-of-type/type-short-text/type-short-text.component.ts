import { Component, OnInit } from '@angular/core';
import {FormTransfer} from "../../../../../shared/interfaces/FormTransfer";
import {Field} from "../../../../../shared/models/Field";

@Component({
  selector: 'formy-type-short-text',
  templateUrl: './type-short-text.component.html',
  styleUrls: ['./type-short-text.component.scss']
})
export class TypeShortTextComponent implements OnInit, FormTransfer {

  public constraintRegexTemplate : string;
  public constraintRegex : string;
  public testRegex : string;
  public isRegexValid : boolean;

  private field : Field;

  constructor() {
    this.isRegexValid = true;
  }

  ngOnInit() {
    this.field = new Field();
  }

  public verifyRegex() {
    try {
      let regex = new RegExp(this.constraintRegexTemplate);
      this.constraintRegex = this.constraintRegexTemplate;
      this.isRegexValid = true;
    }
    catch (e) {
      this.isRegexValid = false;
    }
  }

  public getJson() : Field {
    this.field.options = {
      regex : this.constraintRegexTemplate
    };
    return this.field;
  }

}
