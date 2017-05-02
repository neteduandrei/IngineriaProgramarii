import {Component, Input, OnInit} from '@angular/core';
import {MdDialog, MdDialogRef} from '@angular/material';

@Component({
  selector: 'dialog-share',
  templateUrl: './dialog-share.component.html',
  styleUrls: ['./dialog-share.component.scss']
})
export class DialogShareComponent {
  constructor(public dialogRef: MdDialogRef<DialogShareComponent>) {}

}
