import {Component, Input, OnInit} from '@angular/core';
import {ShareFormEditableService} from '../../../services/share-form-editable.service';

@Component({
  selector: 'formy-editable-long-text',
  templateUrl: './editable-long-text.component.html',
  styleUrls: ['./editable-long-text.component.scss']
})
export class EditableLongTextComponent implements OnInit {

  @Input() positionInArray;

  constructor(public shareFromEditableService : ShareFormEditableService) { }

  ngOnInit() {
  }

}
