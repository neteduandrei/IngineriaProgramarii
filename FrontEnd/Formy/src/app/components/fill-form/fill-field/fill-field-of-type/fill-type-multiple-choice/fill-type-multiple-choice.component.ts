import {Component, Input, OnInit} from '@angular/core';
import {Field} from '../../../../../shared/models/Field';
import {FormTransfer} from '../../../../../shared/interfaces/FormTransfer';

@Component({
  selector: 'formy-fill-type-multiple-choice',
  templateUrl: './fill-type-multiple-choice.component.html',
  styleUrls: ['./fill-type-multiple-choice.component.scss']
})
export class FillTypeMultipleChoiceComponent implements OnInit, FormTransfer {

  @Input() values : Array<string>;
  @Input() field : Field;

  public selectedValues;

  constructor() {
  }

  ngOnInit() {
    this.selectedValues = [];
    this.values.forEach(value => {
      this.selectedValues.push({
        val : value,
        checked : false
      });
    })
  }

  public getSelectedValues() {
    return this.selectedValues
      .filter(value => value.checked === true)
      .forEach(value => console.log(value));
  }

  getJson(): Field {
    this.field.value = this.getSelectedValues();
    return this.field;
  }
}
