import {Component, Input, OnInit, ViewChild, ViewChildren} from '@angular/core';
import {Field} from "../../../shared/models/Field";
import {FillFieldOfTypeComponent} from './fill-field-of-type/fill-field-of-type.component';
import {FormTransfer} from '../../../shared/interfaces/FormTransfer';

@Component({
  selector: 'formy-fill-field',
  templateUrl: './fill-field.component.html',
  styleUrls: ['./fill-field.component.scss']
})
export class FillFieldComponent implements OnInit, FormTransfer {

  @Input() field : Field;
  @ViewChild(FillFieldOfTypeComponent) fieldFieldOfType : FillFieldOfTypeComponent;

  constructor() { }

  ngOnInit() {
  }

  getJson(): Field {
    this.field = this.fieldFieldOfType.getJson();
    return this.field;
  }

}
