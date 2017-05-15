import {AfterContentInit, Component, OnDestroy, OnInit, QueryList, ViewChildren} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormsService} from '../../shared/services/forms/forms.service';
import {FillFieldComponent} from './fill-field/fill-field.component';

@Component({
  selector: 'formy-fill-form',
  templateUrl: './fill-form.component.html',
  styleUrls: ['./fill-form.component.scss'],
  host: {
    'class':'page'
  }
})
export class FillFormComponent implements OnInit {

  @ViewChildren(FillFieldComponent) childFields : QueryList<FillFieldComponent>;

  public formTemplateToFill;

  public id : string;

  public responses : string[];


  constructor(private formsService : FormsService, private router : ActivatedRoute) {
    this.formTemplateToFill = {};
  }

  ngOnInit() {

    this.router.params.subscribe(params => {
      this.id = params['id'];
    });


    this.formsService.getFromById(this.id)
      .subscribe((form) => {
        this.formTemplateToFill = form;
        this.formTemplateToFill.fields = this.formTemplateToFill.fields || [];
        console.log(this.formTemplateToFill);
      });
  }

  public submit() {
    this.responses = [];
    this.childFields.forEach(field => {
      field.submit();
      //this.responses.push(field.field.value);
    });
  }


}
