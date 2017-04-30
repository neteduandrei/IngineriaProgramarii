import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Field} from "../../../../shared/models/Field";
import {FormTransfer} from "../../../../shared/interfaces/FormTransfer";


@Component({
  selector: 'formy-field-of-type',
  templateUrl: './field-of-type.component.html',
  styleUrls: ['./field-of-type.component.scss']
})
export class FieldOfTypeComponent implements OnInit, FormTransfer {

  @Input('type') type;
  @ViewChild('field') field;

  private fieldValue : Field;

  constructor() { }

  ngOnInit() { }

  public getJson() : Field {
    this.fieldValue = this.field.getJson();
    this.fieldValue.type = this.type;
    return this.fieldValue;
  }

}
