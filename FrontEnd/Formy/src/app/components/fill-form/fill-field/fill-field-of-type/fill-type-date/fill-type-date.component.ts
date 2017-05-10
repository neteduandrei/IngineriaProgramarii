import {Component, Input, OnInit} from '@angular/core';
import {FormTransfer} from '../../../../../shared/interfaces/FormTransfer';
import {Field} from '../../../../../shared/models/Field';

@Component({
  selector: 'formy-fill-type-date',
  templateUrl: './fill-type-date.component.html',
  styleUrls: ['./fill-type-date.component.scss']
})
export class FillTypeDateComponent implements OnInit, FormTransfer {

  @Input() field : Field;

  constructor() { }

  ngOnInit() {
  }

  getJson(): Field {
    return this.field;
  }

}
