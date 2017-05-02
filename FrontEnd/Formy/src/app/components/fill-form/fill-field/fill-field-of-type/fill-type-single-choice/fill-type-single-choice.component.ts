import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'formy-fill-type-single-choice',
  templateUrl: './fill-type-single-choice.component.html',
  styleUrls: ['./fill-type-single-choice.component.scss']
})
export class FillTypeSingleChoiceComponent implements OnInit {

  @Input() values : Array<string>;

  constructor() { }

  ngOnInit() {
  }

}
