import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'formy-fill-type-short-text',
  templateUrl: './fill-type-short-text.component.html',
  styleUrls: ['./fill-type-short-text.component.scss']
})
export class FillTypeShortTextComponent implements OnInit {

  @Input() required;
  @Input() options;

  public value : string;

  constructor() { }

  ngOnInit() {
  }

}
