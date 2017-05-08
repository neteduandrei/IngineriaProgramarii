import { Component, OnInit, Input, ViewChild } from '@angular/core';

@Component({
  selector: 'formy-answer-abstract',
  templateUrl: './answer-abstract.component.html',
  styleUrls: ['./answer-abstract.component.scss']
})
export class AnswerAbstractComponent implements OnInit {

  @Input('type') type;
  

  constructor() { }

  ngOnInit() {
  }

}
