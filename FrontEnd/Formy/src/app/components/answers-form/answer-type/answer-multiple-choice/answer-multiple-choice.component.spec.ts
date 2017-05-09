import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerMultipleChoiceComponent } from './answer-multiple-choice.component';

describe('AnswerMultipleChoiceComponent', () => {
  let component: AnswerMultipleChoiceComponent;
  let fixture: ComponentFixture<AnswerMultipleChoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnswerMultipleChoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnswerMultipleChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
