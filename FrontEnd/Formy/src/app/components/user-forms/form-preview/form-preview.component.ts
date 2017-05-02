import {Component, Input, OnInit} from '@angular/core';
import {DialogShareComponent} from "./dialogs/dialog-share.component";
import {MdDialog} from "@angular/material";

@Component({
  selector: 'formy-form-preview',
  templateUrl: './form-preview.component.html',
  styleUrls: ['./form-preview.component.scss']
})
export class FormPreviewComponent implements OnInit {

  @Input() title: string;
  @Input() moreInfo: string;


  constructor(public dialog: MdDialog) {
  }

  public openDialog() {
    let dialogRef = this.dialog.open(DialogShareComponent);

  }

  ngOnInit() {

  }

}
