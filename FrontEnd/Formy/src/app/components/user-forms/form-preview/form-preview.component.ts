import {Component, Input, OnInit} from '@angular/core';
import {DialogShareComponent} from "./dialogs/dialog-share.component";
import {MdDialog} from "@angular/material";
import {FormsService} from '../../../shared/services/forms/forms.service';
import {baseUrl} from '../../../shared/globals';

@Component({
  selector: 'formy-form-preview',
  templateUrl: './form-preview.component.html',
  styleUrls: ['./form-preview.component.scss']
})
export class FormPreviewComponent implements OnInit {

  @Input() title: string;
  @Input() moreInfo: string;
  @Input() id : string;

  constructor(public dialog: MdDialog, private formsService : FormsService) {
  }

  public openDialog() {
    let dialogRef = this.dialog.open(DialogShareComponent);

  }

  public downloadFormAsJson() {
    this.formsService.downloadFile(this.id);
  }

  ngOnInit() {

  }

}
