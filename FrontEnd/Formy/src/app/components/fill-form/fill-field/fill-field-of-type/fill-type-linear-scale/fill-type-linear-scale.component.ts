import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'formy-fill-type-linear-scale',
  templateUrl: './fill-type-linear-scale.component.html',
  styleUrls: ['./fill-type-linear-scale.component.scss']
})
export class FillTypeLinearScaleComponent implements OnInit {

  @Input() values;

  constructor() { }

  ngOnInit() {
  }

}
