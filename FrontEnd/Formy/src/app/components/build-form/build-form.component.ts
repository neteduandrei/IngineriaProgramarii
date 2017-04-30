import { Component, OnInit } from '@angular/core';
import {FieldComponent} from "./field/field.component";

@Component({
  selector: 'formy-build-form',
  templateUrl: './build-form.component.html',
  styleUrls: ['./build-form.component.scss']
})
export class BuildFormComponent implements OnInit {

  public fields : FieldComponent[];

  constructor() {
    this.fields = [];
  }

  ngOnInit() {
    this.fields.push(new FieldComponent);
  }

  public addField() {
    this.fields.push(new FieldComponent);
  }

}
