import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerLinearScaleComponent } from './answer-linear-scale.component';

describe('AnswerLinearScaleComponent', () => {
  let component: AnswerLinearScaleComponent;
  let fixture: ComponentFixture<AnswerLinearScaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnswerLinearScaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnswerLinearScaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
