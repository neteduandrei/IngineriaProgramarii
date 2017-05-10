import {Component, Input, OnInit} from '@angular/core';
import {Field} from '../../../../../shared/models/Field';
import {FormTransfer} from '../../../../../shared/interfaces/FormTransfer';

@Component({
  selector: 'formy-fill-type-long-text',
  templateUrl: './fill-type-long-text.component.html',
  styleUrls: ['./fill-type-long-text.component.scss']
})
export class FillTypeLongTextComponent implements OnInit, FormTransfer {

  @Input() field : Field;

  constructor() { }

  ngOnInit() {
  }

  getJson(): Field {
    return this.field;
  }

}
