import {Component, Input, OnInit} from '@angular/core';
import {Field} from '../../../../../shared/models/Field';
import {FormTransfer} from '../../../../../shared/interfaces/FormTransfer';

@Component({
  selector: 'formy-fill-type-single-choice',
  templateUrl: './fill-type-single-choice.component.html',
  styleUrls: ['./fill-type-single-choice.component.scss']
})
export class FillTypeSingleChoiceComponent implements OnInit, FormTransfer {

  @Input() values : Array<string>;
  @Input() field : Field;

  public selectedButton : string;

  constructor() { }

  ngOnInit() {
  }

  getJson(): Field {
    this.field.value = this.selectedButton;
    return this.field;
  }

}
