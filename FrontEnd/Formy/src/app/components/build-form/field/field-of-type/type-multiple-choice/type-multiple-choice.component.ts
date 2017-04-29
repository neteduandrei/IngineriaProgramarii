import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'formy-type-multiple-choice',
  templateUrl: './type-multiple-choice.component.html',
  styleUrls: ['./type-multiple-choice.component.scss']
})
export class TypeMultipleChoiceComponent implements OnInit {

  public checkValues : string[];

  public addOption() {
    this.checkValues[this.checkValues.length] = `Option ${this.checkValues.length + 1}`;
  }

  constructor() {
    this.checkValues = [];
  }

  ngOnInit() {
    this.checkValues[0] = 'Option 1';
  }

}
