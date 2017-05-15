import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditableMultipleChoiceComponent } from './editable-multiple-choice.component';

describe('EditableMultipleChoiceComponent', () => {
  let component: EditableMultipleChoiceComponent;
  let fixture: ComponentFixture<EditableMultipleChoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditableMultipleChoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditableMultipleChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
