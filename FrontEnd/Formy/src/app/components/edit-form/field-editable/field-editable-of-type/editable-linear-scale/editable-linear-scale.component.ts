import {Component, Input, OnInit} from '@angular/core';
import {ShareFormEditableService} from '../../../services/share-form-editable.service';

@Component({
  selector: 'formy-editable-linear-scale',
  templateUrl: './editable-linear-scale.component.html',
  styleUrls: ['./editable-linear-scale.component.scss']
})
export class EditableLinearScaleComponent implements OnInit {

  @Input() positionInArray;

  public minVals : number[];
  public maxVals : number[];

  constructor(public shareFromEditableService : ShareFormEditableService) { }

  ngOnInit() {
    this.minVals = [0, 1];
    this.maxVals = [2, 3, 4, 5, 6, 7, 8, 9, 10];
  }

}
