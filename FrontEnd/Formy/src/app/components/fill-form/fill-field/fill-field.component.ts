import {Component, Input, OnInit} from '@angular/core';
import {Field} from "../../../shared/models/Field";

@Component({
  selector: 'formy-fill-field',
  templateUrl: './fill-field.component.html',
  styleUrls: ['./fill-field.component.scss']
})
export class FillFieldComponent implements OnInit {

  @Input() field : Field;

  constructor() { }

  ngOnInit() {
  }

}
