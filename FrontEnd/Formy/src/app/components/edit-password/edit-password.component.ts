import { Component, Input, OnChanges, SimpleChange, OnInit } from '@angular/core';
import {FormGroup, FormControl,Validators } from '@angular/forms';

@Component({
  selector: 'formy-edit-password',
  templateUrl: './edit-password.component.html',
  styleUrls: ['./edit-password.component.scss']
})
export class EditPasswordComponent implements OnInit {
  myForm: MyForm;
  constructor() {
    this.myForm = new MyForm();
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
