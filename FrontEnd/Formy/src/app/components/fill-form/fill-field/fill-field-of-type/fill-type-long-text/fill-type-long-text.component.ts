import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'formy-fill-type-long-text',
  templateUrl: './fill-type-long-text.component.html',
  styleUrls: ['./fill-type-long-text.component.scss']
})
export class FillTypeLongTextComponent implements OnInit {

  @Input() options;
  @Input() required : boolean;

  public value : string;

  constructor() { }

  ngOnInit() {
  }

}
