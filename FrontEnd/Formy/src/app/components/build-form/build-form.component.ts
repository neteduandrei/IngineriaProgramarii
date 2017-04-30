import {Component, OnInit, QueryList, ViewChild} from '@angular/core';
import {FieldComponent} from "./field/field.component";

@Component({
  selector: 'formy-build-form',
  templateUrl: './build-form.component.html',
  styleUrls: ['./build-form.component.scss'],
  host: {
    class:'page'
  }
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

  public delete(index : number) {
    this.fields.splice(index, 1);
  }

}
