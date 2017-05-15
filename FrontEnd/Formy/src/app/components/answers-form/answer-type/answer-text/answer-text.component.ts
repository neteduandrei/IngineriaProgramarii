import { Component, OnInit } from '@angular/core';

export class QuestionText {
  public title: string;
  public answers: string[];
}

const DUMMY: QuestionText = {
  title: 'Is this a text question?',
  answers: [
    'depends on your definition of question', 'dunno, is this an answer?', 'these are just placeholders aren\'t they?'
  ]
};

@Component({
  selector: 'formy-answer-text',
  templateUrl: './answer-text.component.html',
  styleUrls: ['./answer-text.component.scss']
})

export class AnswerTextComponent implements OnInit {

  question = DUMMY;

  constructor() { }

  ngOnInit() {
  }

}
