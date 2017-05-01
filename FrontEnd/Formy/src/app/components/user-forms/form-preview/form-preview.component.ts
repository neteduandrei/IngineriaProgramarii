import { Component, OnInit } from '@angular/core';
import {MdDialog, MdDialogRef} from '@angular/material';

@Component({
  selector: 'formy-form-preview',
  templateUrl: './form-preview.component.html',
  styleUrls: ['./form-preview.component.scss']
})
export class FormPreviewComponent implements OnInit {

  constructor(public dialog: MdDialog) { }

  public openDialog() {
    console.log('test');
    let dialogRef = this.dialog.open(DialogShareComponent);

  }

  ngOnInit() {
  }

}


@Component({
  selector: 'dialog-share',
  templateUrl: './dialogs/dialog-share.component.html',
  styleUrls: ['./dialogs/dialog-share.component.scss']
})
export class DialogShareComponent {
  constructor(public dialogRef: MdDialogRef<DialogShareComponent>) {}

}
