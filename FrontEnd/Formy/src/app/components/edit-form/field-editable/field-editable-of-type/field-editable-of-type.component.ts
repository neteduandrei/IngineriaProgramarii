import {Component, Input, OnInit} from '@angular/core';
import {ShareFormEditableService} from '../../services/share-form-editable.service';

@Component({
  selector: 'formy-field-editable-of-type',
  templateUrl: './field-editable-of-type.component.html',
  styleUrls: ['./field-editable-of-type.component.scss']
})
export class FieldEditableOfTypeComponent implements OnInit {

  @Input() positionInArray;

  constructor(public shareFromEditableService : ShareFormEditableService) { }

  ngOnInit() {
  }

}
