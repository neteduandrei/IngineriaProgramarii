import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'formy-field',
  templateUrl: './field.component.html',
  styleUrls: ['./field.component.scss']
})
export class FieldComponent implements OnInit {

  public options: Option[] = [
    {value : 'shortText', viewValue: 'Short Text'},
    {value : 'longText', viewValue: 'Long Text'},
    {value : 'singleChoice', viewValue: 'Single Choice'},
    {value : 'multipleChoice', viewValue: 'Multiple Choice'},
    {value : 'date', viewValue: 'Date'},
    {value: 'linearScale', viewValue: 'Linear Scale'}
  ];

  public selectedOption;

  constructor() { }

  ngOnInit() {
    this.selectedOption = 'shortText';
  }

}

class Option {
  public value: string;
  public viewValue: string;
}
