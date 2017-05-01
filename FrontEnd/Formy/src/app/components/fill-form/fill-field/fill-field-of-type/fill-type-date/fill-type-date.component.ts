import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'formy-fill-type-date',
  templateUrl: './fill-type-date.component.html',
  styleUrls: ['./fill-type-date.component.scss']
})
export class FillTypeDateComponent implements OnInit {

  public value : Date;

  constructor() { }

  ngOnInit() {
  }

}
