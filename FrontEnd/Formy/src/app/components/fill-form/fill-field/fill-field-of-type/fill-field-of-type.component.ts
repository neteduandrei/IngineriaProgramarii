import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Field} from '../../../../shared/models/Field';
import {FormTransfer} from '../../../../shared/interfaces/FormTransfer';

@Component({
  selector: 'formy-fill-field-of-type',
  templateUrl: './fill-field-of-type.component.html',
  styleUrls: ['./fill-field-of-type.component.scss']
})
export class FillFieldOfTypeComponent implements OnInit, FormTransfer {

  @Input() field : Field;
  @ViewChild('field2') field2;

  constructor() { }

  ngOnInit() {
  }

  getJson(): Field {
    this.field = this.field2.getJson();
    return this.field;
  }

}
