import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'formy-type-single-choice',
  templateUrl: './type-single-choice.component.html',
  styleUrls: ['./type-single-choice.component.scss']
})
export class TypeSingleChoiceComponent implements OnInit {

  public radioValues : string[];

  public addOption() {
    this.radioValues[this.radioValues.length] = `Option ${this.radioValues.length + 1}`;
  }

  constructor() {
    this.radioValues = [];
  }

  ngOnInit() {
    this.radioValues[0] = 'Option 1';
  }

}
