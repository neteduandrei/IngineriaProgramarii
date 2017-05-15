import {Component, Input, OnInit} from '@angular/core';
import {ShareFormEditableService} from '../../../services/share-form-editable.service';

@Component({
  selector: 'formy-editable-single-choice',
  templateUrl: './editable-single-choice.component.html',
  styleUrls: ['./editable-single-choice.component.scss']
})
export class EditableSingleChoiceComponent implements OnInit {

  @Input() positionInArray;

  public radioValues : string[];
  public size : number;


  constructor(public shareFromEditableService : ShareFormEditableService) { }

  ngOnInit() {
    this.size = this.shareFromEditableService.form.fields[this.positionInArray].value.length || 0;
  }

  public addOption() {
    this.shareFromEditableService.form.fields[this.positionInArray].value
      .push(`Option ${this.shareFromEditableService.form.fields[this.positionInArray].value.length + 1}`);
  }

  trackByFnChange(array) {
    let i = array;
    let len = i.length;
    return function(index, element) {
      if(len != i.length) {
        len = i.length;
        return true;
      } else {
        return false;
      }
    }
  }
}
