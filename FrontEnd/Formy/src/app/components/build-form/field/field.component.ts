import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {FieldOfTypeComponent} from "./field-of-type/field-of-type.component";
import {FormTransfer} from "../../../shared/interfaces/FormTransfer";
import {Field} from "../../../shared/models/Field";

@Component({
  selector: 'formy-field',
  templateUrl: './field.component.html',
  styleUrls: ['./field.component.scss']
})
export class FieldComponent implements OnInit, FormTransfer, FormTransfer {

  @Output() delete: EventEmitter<any> = new EventEmitter();
  @ViewChild(FieldOfTypeComponent) fieldOfTypeComponent : FieldOfTypeComponent;

  public question : string;
  public description : string;

  private required : boolean;
  private field : Field;

  public options: Option[] = [
    {value : 'shortText', viewValue: 'Short Text'},
    {value : 'longText', viewValue: 'Long Text'},
    {value : 'singleChoice', viewValue: 'Single Choice'},
    {value : 'multipleChoice', viewValue: 'Multiple Choice'},
    {value : 'date', viewValue: 'Date'},
    {value : 'linearScale', viewValue: 'Linear Scale'}
  ];

  public selectedOption;

  constructor() { }

  ngOnInit() {
    this.selectedOption = 'shortText';
    this.required = false;
  }

  public deleteItem() {
    this.delete.emit(null);
  }

  public changeToggle() {
    this.required = !this.required;
  }

  public getJson() : Field {
    this.field = this.fieldOfTypeComponent.getJson();
    this.field.required = this.required;
    this.field.title = this.question;
    this.field.description = this.description;
    return this.field;
  }

}

class Option {
  public value: string;
  public viewValue: string;
}
