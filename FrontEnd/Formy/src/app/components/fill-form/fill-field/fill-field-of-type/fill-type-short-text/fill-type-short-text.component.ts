import {Component, Input, OnInit} from '@angular/core';
import {Field} from '../../../../../shared/models/Field';
import {FormTransfer} from '../../../../../shared/interfaces/FormTransfer';

@Component({
  selector: 'formy-fill-type-short-text',
  templateUrl: './fill-type-short-text.component.html',
  styleUrls: ['./fill-type-short-text.component.scss']
})
export class FillTypeShortTextComponent implements OnInit, FormTransfer {

  @Input() field : Field;

  constructor() { }

  ngOnInit() {
  }

  getJson(): Field {
    return this.field;
  }

}
