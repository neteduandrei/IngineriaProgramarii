import { Component, OnInit } from '@angular/core';
import {FormTransfer} from "../../../../../shared/interfaces/FormTransfer";
import {Field} from "../../../../../shared/models/Field";

@Component({
  selector: 'formy-type-long-text',
  templateUrl: './type-long-text.component.html',
  styleUrls: ['./type-long-text.component.scss']
})
export class TypeLongTextComponent implements OnInit, FormTransfer {

  public field : Field;

  constructor() { }

  ngOnInit() {
    this.field = new Field();
  }

  public getJson() : Field {
    this.field.options = {
      maxLength: 512
    };

    return this.field;
  }



}
