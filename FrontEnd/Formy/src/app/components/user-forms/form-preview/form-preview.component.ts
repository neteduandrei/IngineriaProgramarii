import { Component, OnInit } from '@angular/core';
import {MdDialog, MdDialogRef} from '@angular/material';

@Component({
  selector: 'formy-form-preview',
  templateUrl: './form-preview.component.html',
  styleUrls: ['./form-preview.component.scss']
})
export class FormPreviewComponent implements OnInit {

  public title: string;
  public moreInfo: string;

  constructor(public dialog: MdDialog) {
    this.title = 'Form Example';
    this.moreInfo = 'Apr 30, 13.37 KB';
  }

  public openDialog() {
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
