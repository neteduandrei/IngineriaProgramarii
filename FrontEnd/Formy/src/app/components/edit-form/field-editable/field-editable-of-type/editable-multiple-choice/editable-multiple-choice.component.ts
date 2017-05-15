import {Component, Input, OnInit} from '@angular/core';
import {ShareFormEditableService} from '../../../services/share-form-editable.service';

@Component({
  selector: 'formy-editable-multiple-choice',
  templateUrl: './editable-multiple-choice.component.html',
  styleUrls: ['./editable-multiple-choice.component.scss']
})
export class EditableMultipleChoiceComponent implements OnInit {

  @Input() positionInArray;

  public checkValues : string[];

  constructor(public shareFromEditableService : ShareFormEditableService) { }

  public addOption() {
    this.checkValues[this.checkValues.length] = `Option ${this.checkValues.length + 1}`;
    this.shareFromEditableService.form.fields[this.positionInArray].value = this.checkValues;
  }

  ngOnInit() {
    for(let i = 0; i < this.shareFromEditableService.form.fields[this.positionInArray].value; ++i) {
      this.checkValues[i] = this.shareFromEditableService.form.fields[this.positionInArray].value[i];
    }
  }

}
