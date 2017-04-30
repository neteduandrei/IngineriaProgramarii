import { Component, OnInit } from '@angular/core';
import {Field} from "../../../../../shared/models/Field";
import {FormTransfer} from "../../../../../shared/interfaces/FormTransfer";

@Component({
  selector: 'formy-type-linear-scale',
  templateUrl: './type-linear-scale.component.html',
  styleUrls: ['./type-linear-scale.component.scss']
})
export class TypeLinearScaleComponent implements OnInit, FormTransfer {

  public minVals : number[];
  public maxVals : number[];

  public selectedMinVal : number;
  public selectedMaxVal : number;

  private field : Field;

  constructor() {
    this.minVals = [0, 1];
    this.maxVals = [2, 3, 4, 5, 6, 7, 8, 9, 10];
  }

  ngOnInit() {
    this.selectedMinVal = this.minVals[1];
    this.selectedMaxVal = this.maxVals[3];
    this.field = new Field();
  }

  public getJson() : Field {
    this.field.value = {
      min : this.selectedMinVal,
      max : this.selectedMaxVal
    };
    return this.field;
  }

}
