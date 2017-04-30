import { Component, OnInit } from '@angular/core';
import {Field} from "../../../../../shared/models/Field";
import {FormTransfer} from "../../../../../shared/interfaces/FormTransfer";

@Component({
  selector: 'formy-type-single-choice',
  templateUrl: './type-single-choice.component.html',
  styleUrls: ['./type-single-choice.component.scss']
})
export class TypeSingleChoiceComponent implements OnInit, FormTransfer {

  public radioValues : string[];

  private field : Field;

  public addOption() {
    this.radioValues[this.radioValues.length] = `Option ${this.radioValues.length + 1}`;
  }

  constructor() {
    this.radioValues = [];
  }

  ngOnInit() {
    this.radioValues[0] = 'Option 1';
    this.field = new Field();
  }

  public getJson() : Field {
    this.field.value = this.radioValues;
    return this.field;
  }

}
