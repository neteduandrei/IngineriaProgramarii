import {Component, OnInit, QueryList, ViewChildren} from '@angular/core';
import {FormPreviewComponent} from './form-preview/form-preview.component'
import {MdDialog} from "@angular/material";

@Component({
  selector: 'formy-user-forms',
  templateUrl: './user-forms.component.html',
  styleUrls: ['./user-forms.component.scss'],
  host: {
    class:'page'
  }
})
export class UserFormsComponent implements OnInit {

  public forms: FormPreviewComponent[];

  constructor() {
    this.forms = [];
  }

  ngOnInit() {
    /*
    let test: FormPreviewComponent;
    test.title = 'Test Title';
    test.moreInfo = 'Apr 30, 141 KB';
    this.forms.push(test);
    */
  }

  public addForm(form: FormPreviewComponent){
    this.forms.push(form);
  }

  public deleteForm(index: number){
    this.forms.splice(index, 1);
  }

}
