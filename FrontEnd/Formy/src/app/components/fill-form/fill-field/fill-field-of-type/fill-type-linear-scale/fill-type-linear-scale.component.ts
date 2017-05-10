import {Component, Input, OnInit} from '@angular/core';
import {Field} from '../../../../../shared/models/Field';
import {FormTransfer} from '../../../../../shared/interfaces/FormTransfer';

@Component({
  selector: 'formy-fill-type-linear-scale',
  templateUrl: './fill-type-linear-scale.component.html',
  styleUrls: ['./fill-type-linear-scale.component.scss']
})
export class FillTypeLinearScaleComponent implements OnInit, FormTransfer {


  @Input() field : Field;

  @Input() values;

  constructor() { }

  ngOnInit() {
  }

  getJson(): Field {
    return this.field;
  }

}
