import {Component, Input, OnInit, ViewChild, ViewChildren} from '@angular/core';
import {Field} from "../../../shared/models/Field";
import {FillFieldOfTypeComponent} from './fill-field-of-type/fill-field-of-type.component';
import {FormTransfer} from '../../../shared/interfaces/FormTransfer';
import {QuestionsService} from '../../../shared/services/questions/questions.service';

@Component({
  selector: 'formy-fill-field',
  templateUrl: './fill-field.component.html',
  styleUrls: ['./fill-field.component.scss']
})
export class FillFieldComponent implements OnInit, FormTransfer {

  @Input() field;
  @Input() formId;
  @ViewChild(FillFieldOfTypeComponent) fieldFieldOfType : FillFieldOfTypeComponent;

  constructor(private questionsService : QuestionsService) { }

  ngOnInit() {
  }

  getJson(): Field {
    this.field = this.fieldFieldOfType.getJson();
    return this.field;
  }

  submit() {
    this.field = this.fieldFieldOfType.getJson();
    let res = new Response();
    res.formId = this.formId;
    res.quesitonId = this.field.id;
    res.questionType = this.field.type;
    res.answers =  [];
    res.answers.push(this.field.value);
    this.questionsService.sendQuestion(res).subscribe(
      (data) => console.log(data)
    );
  }

}

class Response {
  public formId : string;
  public quesitonId : string;
  public questionType : string;
  public answers : Array<string>;
}
