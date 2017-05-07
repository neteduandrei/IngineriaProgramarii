import {Component, OnInit, QueryList, ViewChildren} from '@angular/core';
import {FieldComponent} from "./field/field.component";
import {FormTemplateGenerator} from "../../shared/models/FormTemplateGenerator";
import {Form} from "app/shared/models/Form";
import {BuildFormService} from "../../shared/services/build-form/build-form.service";

@Component({
  selector: 'formy-build-form',
  templateUrl: './build-form.component.html',
  styleUrls: ['./build-form.component.scss'],
  host: {
    class:'page'
  }
})
export class BuildFormComponent implements OnInit {

  @ViewChildren(FieldComponent) childFields : QueryList<FieldComponent>;

 // public fields : FieldComponent[];
  public fields : number[];
  public title : string;
  public description : string;

  private formGenerator : FormTemplateGenerator;

  constructor(private buildFormService : BuildFormService) {
    this.fields = [];
  }

  ngOnInit() {
   // this.fields.push(new FieldComponent);
    this.fields.push(0);

  }

  public addField() {
   // this.fields.push(new FieldComponent);
    this.fields.push(0);
  }

  public delete(index : number) {
    this.fields.splice(index, 1);
  }

  public save() {

    this.formGenerator = new FormTemplateGenerator();
    this.formGenerator.form = new Form;
    this.formGenerator.form.fields = [];

    this.childFields.forEach(field => {
      this.formGenerator.form.fields.push(field.getJson());
    });
    this.formGenerator.form.title = this.title;
    this.formGenerator.form.description = this.description;
    this.formGenerator.owner=""; //must ask auth service
    /* should send this to a service */

    this.buildFormService.sendForm(this.formGenerator).subscribe(
      (response) => console.log(response)
    );

  }

}


