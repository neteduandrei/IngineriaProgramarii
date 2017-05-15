import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditableSingleChoiceComponent } from './editable-single-choice.component';

describe('EditableSingleChoiceComponent', () => {
  let component: EditableSingleChoiceComponent;
  let fixture: ComponentFixture<EditableSingleChoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditableSingleChoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditableSingleChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
