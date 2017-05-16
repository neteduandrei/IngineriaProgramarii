import { Component, Input, OnInit} from '@angular/core';
import {ShareFormEditableService} from '../services/share-form-editable.service';

@Component({
  selector: 'formy-field-editable',
  templateUrl: './field-editable.component.html',
  styleUrls: ['./field-editable.component.scss']
})
export class FieldEditableComponent implements OnInit {

  @Input() positionInArray : number;

  public options: Option[] = [
    {value : 'shortText', viewValue: 'Short Text'},
    {value : 'longText', viewValue: 'Long Text'},
    {value : 'singleChoice', viewValue: 'Single Choice'},
    {value : 'multipleChoice', viewValue: 'Multiple Choice'},
    {value : 'date', viewValue: 'Date'},
    {value : 'linearScale', viewValue: 'Linear Scale'}
  ];

  public selectedOption : string;

  constructor(public shareFromEditableService : ShareFormEditableService) { }

  ngOnInit() {

  }

  public changeToggle() {
    this.shareFromEditableService.form.fields[this.positionInArray].required = !this.shareFromEditableService.form.fields[this.positionInArray].required;
  }

}

class Option {
  public value: string;
  public viewValue: string;
}
