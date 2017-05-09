import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerAbstractComponent } from './answer-abstract.component';

describe('AnswerAbstractComponent', () => {
  let component: AnswerAbstractComponent;
  let fixture: ComponentFixture<AnswerAbstractComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnswerAbstractComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnswerAbstractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
