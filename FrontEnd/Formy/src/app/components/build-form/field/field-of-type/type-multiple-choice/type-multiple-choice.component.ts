import { Component, OnInit } from '@angular/core';
import {FormTransfer} from "../../../../../shared/interfaces/FormTransfer";
import {Field} from "../../../../../shared/models/Field";

@Component({
  selector: 'formy-type-multiple-choice',
  templateUrl: './type-multiple-choice.component.html',
  styleUrls: ['./type-multiple-choice.component.scss']
})
export class TypeMultipleChoiceComponent implements OnInit, FormTransfer {

  public checkValues : string[];

  private field : Field;

  public addOption() {
    this.checkValues[this.checkValues.length] = `Option ${this.checkValues.length + 1}`;
  }

  constructor() {
    this.checkValues = [];
  }

  ngOnInit() {
    this.checkValues[0] = 'Option 1';
    this.field = new Field();
  }

  public getJson() : Field {
    this.field.value = this.checkValues;
    return this.field;
  }

}
