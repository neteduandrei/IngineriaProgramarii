import { Component, OnInit } from '@angular/core';
import {BuildFormService} from '../../shared/services/build-form/build-form.service';
import {ShareFormEditableService} from './services/share-form-editable.service';
import {ActivatedRoute} from '@angular/router';
import {FormsService} from '../../shared/services/forms/forms.service';

@Component({
  selector: 'formy-edit-form',
  templateUrl: './edit-form.component.html',
  styleUrls: ['./edit-form.component.scss'],
  host: {
    class:'page'
  }
})
export class EditFormComponent implements OnInit {

  public fields : number[];
  public id : string;

  constructor(
    private buildFormService : BuildFormService,
    public shareFromEditableService : ShareFormEditableService,
    private activatedRoute : ActivatedRoute,
    private formsService : FormsService
  ) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id'];
    });

   // this.shareFromEditableService.form = this.buildFormService.getFormTemplate();
/*
    if(this.buildFormService.formReceiveTemplate != null && this.buildFormService.formReceiveTemplate.id === this.id) {
      this.shareFromEditableService.form = this.buildFormService.getFormTemplate();
    }
    else {
      this.formsService.getFromById(this.id)
        .subscribe(response => {
          this.shareFromEditableService.form = response;
        });

    }
*/
    this.fields = [];
    for(let i = 0; i < this.shareFromEditableService.form.fields.length; ++i) {
      this.fields.push(0);
    }
  }

  public save() {
    this.formsService.update(this.shareFromEditableService.form)
      .subscribe(response => console.log(response));
  }

}
