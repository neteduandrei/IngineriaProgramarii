import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerSingleChoiceComponent } from './answer-single-choice.component';

describe('AnswerSingleChoiceComponent', () => {
  let component: AnswerSingleChoiceComponent;
  let fixture: ComponentFixture<AnswerSingleChoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnswerSingleChoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnswerSingleChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
