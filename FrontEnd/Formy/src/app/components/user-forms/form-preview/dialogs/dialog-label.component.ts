import {Component, Input, OnInit} from '@angular/core';
import {MdDialog, MdDialogRef, MdSnackBar} from '@angular/material';

@Component({
  selector: 'dialog-label',
  templateUrl: './dialog-label.component.html',
  styleUrls: ['./dialog-label.component.scss']
})
export class DialogLabelComponent {

  public link : string;

  constructor(public dialogRef: MdDialogRef<DialogLabelComponent>, public snackBar: MdSnackBar) {}

  openSnackBar() {
    this.dialogRef.close();
    var addLabelInput = (<HTMLInputElement>document.getElementById("addLabelInput")).value;
    let snackBarRef = this.snackBar.open('Added label ' + addLabelInput,'DISMISS',{duration: 3000});
  }
}
