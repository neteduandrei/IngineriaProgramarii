import {Component, OnDestroy, OnInit} from '@angular/core';
import { FillFormService } from "../../shared/services/fill-form/fill-form.service";
import { FormTemplateToFill } from "../../shared/models/FormTemplateToFill";
import { Form } from "../../shared/models/Form";
import { Field } from "../../shared/models/Field";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'formy-fill-form',
  templateUrl: './fill-form.component.html',
  styleUrls: ['./fill-form.component.scss'],
  host: {
    'class':'page'
  }
})
export class FillFormComponent implements OnInit {

  public formTemplateToFill : FormTemplateToFill;

  public id : string;


  constructor(private fillFormService : FillFormService, private router : ActivatedRoute) { }

  ngOnInit() {

    this.router.params.subscribe(params => {
      this.id = params['id'];
    });


    this.fillFormService.getForm(this.id)
      .subscribe((form : FormTemplateToFill) => {
        this.formTemplateToFill = form;
      });

  }

}
