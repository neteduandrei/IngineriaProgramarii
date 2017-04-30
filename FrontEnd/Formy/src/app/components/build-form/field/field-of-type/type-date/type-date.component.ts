import { Component, OnInit } from '@angular/core';
import {Field} from "../../../../../shared/models/Field";
import {FormTransfer} from "../../../../../shared/interfaces/FormTransfer";

@Component({
  selector: 'formy-type-date',
  templateUrl: './type-date.component.html',
  styleUrls: ['./type-date.component.scss']
})
export class TypeDateComponent implements OnInit, FormTransfer {

  public value : Date;

  private field : Field;

  constructor() { }

  ngOnInit() {
    this.field = new Field();
  }

  public getJson() : Field {
    this.field.value = this.value;
    return this.field;
  }

}
