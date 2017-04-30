import { Component, Input, OnChanges, SimpleChange, OnInit } from '@angular/core';
import {FormGroup, FormControl,Validators } from '@angular/forms';

@Component({
  selector: 'formy-edit-password',
  templateUrl: './edit-password.component.html',
  styleUrls: ['./edit-password.component.css']
})
export class EditPasswordComponent implements OnInit {
	form;
  constructor() { }

  ngOnInit() {
  		this.form = new FormGroup({
  		currentPassword: new FormControl("",Validators.required),
  		newPassword: new FormControl(""),
  		confirmNewPassword: new FormControl("") 
  		});
  }

  	onSubmit = function(user){
  		console.log(user);
  	}
}
