import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'formy-field-of-type',
  templateUrl: './field-of-type.component.html',
  styleUrls: ['./field-of-type.component.scss']
})
export class FieldOfTypeComponent implements OnInit {

  @Input('type') type;
  public template;

  public types = new Map<string, string>();

  constructor() {
    this.types.set('shortText', '<formy-type-short-text></formy-type-short-text>' );
    this.types.set('longText', 'Short Text' );
    this.types.set('singleChoice', 'Short Text' );
    this.types.set('multipleChoice', 'Short Text' );
    this.types.set('date', 'Short Text' );
    this.types.set('linearScale', 'Short Text' );
  }

  ngOnInit() {
    this.template = this.types.get(this.type);
  }

}
