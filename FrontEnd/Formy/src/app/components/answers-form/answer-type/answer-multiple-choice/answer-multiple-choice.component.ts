import { Component, OnInit } from '@angular/core';

export const dummy = [
  {
    "name": "Game of thrones",
    "value": 8940000
  },
  {
    "name": "Westworld",
    "value": 5000000
  },
  {
    "name": "None",
    "value": 7200000
  }
];


@Component({
  selector: 'formy-answer-multiple-choice',
  templateUrl: './answer-multiple-choice.component.html',
  styleUrls: ['./answer-multiple-choice.component.scss']
})
export class AnswerMultipleChoiceComponent implements OnInit {

  title: string = 'What is your favorite tv show?';

  view: any[] = [700, 400];

  // options
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'Choices';
  showYAxisLabel = true;
  yAxisLabel = 'Answers';

  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };

  constructor() {
    Object.assign(this, {dummy});
  }

  onSelect(event) {
    console.log(event);
  }

  ngOnInit() {
  }

}
