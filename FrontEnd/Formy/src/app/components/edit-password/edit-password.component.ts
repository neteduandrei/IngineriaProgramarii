import { Component, OnInit } from '@angular/core';
import {MdDialog, MdDialogRef} from '@angular/material';


@Component({
  selector: 'formy-edit-password',
  templateUrl: './edit-password.component.html',
  styleUrls: ['./edit-password.component.scss']
})
export class EditPasswordComponent implements OnInit {
  myForm: MyForm;
  selectedOption: string;
  constructor(public dialog: MdDialog) {this.myForm = new MyForm(); }
  openDialog() {
    let dialogRef = this.dialog.open(DialogDeleteComponent);
    dialogRef.afterClosed().subscribe(result => {
      this.selectedOption = result;
    });
  }

  ngOnInit() {
  }

   submit(myForm){
    console.log(myForm);
  }
}

class MyForm {
  public currentPassword: string;
  public newPassword: string;
  public confirmNewPassword: string;
}


@Component({
  selector: 'dialog-delete',
  templateUrl: './dialog-delete.component.html',
  styleUrls: ['./dialog-delete.component.scss']
})
export class DialogDeleteComponent {
  constructor(public dialogRef: MdDialogRef<DialogDeleteComponent>) {}
}


