import {Component, Input, OnInit} from '@angular/core';
import {DialogShareComponent} from "./dialogs/dialog-share.component";
import {DialogLabelComponent} from "./dialogs/dialog-label.component";
import {MdDialog, MdSnackBar} from "@angular/material";
import {FormsService} from '../../../shared/services/forms/forms.service';
import {baseUrl} from '../../../shared/globals';
import {BuildFormService} from '../../../shared/services/build-form/build-form.service';
import {Router} from '@angular/router';

@Component({
  selector: 'formy-form-preview',
  templateUrl: './form-preview.component.html',
  styleUrls: ['./form-preview.component.scss']
})
export class FormPreviewComponent implements OnInit {

  @Input() form;

  constructor(public dialog: MdDialog,
              private formsService : FormsService,
              private buildFormService : BuildFormService,
              private router : Router) {
  }

  public openDialog() {
    let dialogRef = this.dialog.open(DialogShareComponent);
    dialogRef.componentInstance.link = window.location.hostname + `:4200/form/fill/${ this.form.id}`;

  }

  public openLabelDialog() {
    let labelDialogRef = this.dialog.open(DialogLabelComponent);
  }

  public downloadFormAsJson() {
    this.formsService.downloadFile(this.form.id);
  }

  ngOnInit() {

  }

  public editForm(){
    this.buildFormService.setForm(this.form);
    this.router.navigate([`/form/edit/${this.form.id}`]);
  }

}
