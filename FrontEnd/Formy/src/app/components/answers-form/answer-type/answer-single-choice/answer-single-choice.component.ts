import { Component, OnInit } from '@angular/core';


export const dummy = [
  {
    "name": "Yes",
    "value": 12
  },
  {
    "name": "No",
    "value": 5
  },
  {
    "name": "Dunno",
    "value": 2
  }
];

@Component({
  selector: 'formy-answer-single-choice',
  templateUrl: './answer-single-choice.component.html',
  styleUrls: ['./answer-single-choice.component.scss']
})

export class AnswerSingleChoiceComponent implements OnInit {

  title: string = 'Is this a single choice question with piechart?';

  test: number = 400;

  view: any[] = [700, 400];

  // options
  showLegend = true;

  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };

  // pie
  showLabels = true;
  explodeSlices = false;
  doughnut = false;

  constructor() {
    Object.assign(this, {dummy});
  }

  onSelect(event) {
    console.log(event);
  }



  ngOnInit() {}

}
