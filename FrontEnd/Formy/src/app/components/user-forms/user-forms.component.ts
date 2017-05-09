import {Component, OnInit, QueryList, ViewChildren} from '@angular/core';
import {FormPreviewComponent} from './form-preview/form-preview.component'
import {MdDialog} from "@angular/material";
import {FormsService} from "../../shared/services/forms/forms.service";

@Component({
  selector: 'formy-user-forms',
  templateUrl: './user-forms.component.html',
  styleUrls: ['./user-forms.component.scss'],
  host: {
    class:'page'
  }
})
export class UserFormsComponent implements OnInit {

  public forms;

  constructor(private formsService : FormsService) {
    this.forms = [];
  }

  ngOnInit() {
    this.formsService.getAllForms()
      .subscribe((data) => this.forms = data);
  }

  public addForm(form: FormPreviewComponent){
    this.forms.push(form);
  }

  public deleteForm(index: number){
    this.forms.splice(index, 1);
  }

}
