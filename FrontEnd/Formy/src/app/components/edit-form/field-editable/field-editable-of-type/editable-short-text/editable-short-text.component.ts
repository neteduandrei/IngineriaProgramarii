import {Component, Input, OnInit} from '@angular/core';
import {ShareFormEditableService} from '../../../services/share-form-editable.service';

@Component({
  selector: 'formy-editable-short-text',
  templateUrl: './editable-short-text.component.html',
  styleUrls: ['./editable-short-text.component.scss']
})
export class EditableShortTextComponent implements OnInit {

  @Input() positionInArray;

  public constraintRegexTemplate;
  public isRegexValid;
  public constraintRegex;

  constructor(public shareFromEditableService : ShareFormEditableService) { }

  ngOnInit() {
    this.constraintRegexTemplate = this.shareFromEditableService.form.fields[this.positionInArray].options.regex;
    this.isRegexValid = true;
  }

  public verifyRegex() {
    try {
      let regex = new RegExp(this.constraintRegexTemplate);
      this.constraintRegex = this.constraintRegexTemplate;
      this.shareFromEditableService.form.fields[this.positionInArray].options = {regex: this.constraintRegex};
      this.isRegexValid = true;
    }
    catch (e) {
      this.isRegexValid = false;
    }
  }

}
