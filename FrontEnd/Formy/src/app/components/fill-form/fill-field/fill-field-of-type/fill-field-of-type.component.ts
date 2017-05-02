import {Component, Input, OnInit} from '@angular/core';
import {Field} from "../../../../shared/models/Field";

@Component({
  selector: 'formy-fill-field-of-type',
  templateUrl: './fill-field-of-type.component.html',
  styleUrls: ['./fill-field-of-type.component.scss']
})
export class FillFieldOfTypeComponent implements OnInit {

  @Input() field : Field;

  constructor() { }

  ngOnInit() {
  }

}
