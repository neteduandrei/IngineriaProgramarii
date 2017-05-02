import {Component, Input, OnInit} from '@angular/core';
import {forEach} from "@angular/router/src/utils/collection";

@Component({
  selector: 'formy-fill-type-multiple-choice',
  templateUrl: './fill-type-multiple-choice.component.html',
  styleUrls: ['./fill-type-multiple-choice.component.scss']
})
export class FillTypeMultipleChoiceComponent implements OnInit {

  @Input() values : Array<string>;

  public selectedValues;

  constructor() {
  }

  ngOnInit() {
    this.selectedValues = [];
    this.values.forEach(value => {
      this.selectedValues.push({
        val : value,
        checked : false
      });
    })
  }

  public getSelectedValues() {
    this.selectedValues
      .filter(value => value.checked === true)
      .forEach(value => console.log(value));
  }
}
