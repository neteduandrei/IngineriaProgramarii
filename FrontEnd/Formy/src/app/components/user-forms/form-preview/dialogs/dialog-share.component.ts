import {Component, Input, OnInit} from '@angular/core';
import {MdDialog, MdDialogRef, MdSnackBar} from '@angular/material';

@Component({
  selector: 'dialog-share',
  templateUrl: './dialog-share.component.html',
  styleUrls: ['./dialog-share.component.scss']
})
export class DialogShareComponent {
  constructor(public dialogRef: MdDialogRef<DialogShareComponent>, public snackBar: MdSnackBar) {}

  openSnackBar() {
    let snackBarRef = this.snackBar.open('Link coppied to clipboard','DISMISS',{duration: 3000});
  }
}
