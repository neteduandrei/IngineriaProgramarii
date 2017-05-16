import { Component, OnInit } from '@angular/core';

export const dummy = [
  {
    'name': '1',
    'value': 1337
  },
  {
    'name': '2',
    'value': 10341
  },
  {
    'name': '3',
    'value': 14613
  },
  {
    'name': '4',
    'value': 9870
  },
  {
    'name': '5',
    'value': 500
  }
];

@Component({
  selector: 'formy-answer-linear-scale',
  templateUrl: './answer-linear-scale.component.html',
  styleUrls: ['./answer-linear-scale.component.scss']
})
export class AnswerLinearScaleComponent implements OnInit {

  title: string = 'On a scale from 1 to 5 how much do you like the charts?';

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
