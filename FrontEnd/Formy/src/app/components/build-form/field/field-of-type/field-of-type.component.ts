import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'formy-field-of-type',
  templateUrl: './field-of-type.component.html',
  styleUrls: ['./field-of-type.component.scss']
})
export class FieldOfTypeComponent implements OnInit {

  @Input('type') type;
  constructor() { }

  ngOnInit() { }

}
