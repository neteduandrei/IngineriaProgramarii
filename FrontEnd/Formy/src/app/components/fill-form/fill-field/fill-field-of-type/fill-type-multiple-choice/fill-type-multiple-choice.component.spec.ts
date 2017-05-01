import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FillTypeMultipleChoiceComponent } from './fill-type-multiple-choice.component';

describe('FillTypeMultipleChoiceComponent', () => {
  let component: FillTypeMultipleChoiceComponent;
  let fixture: ComponentFixture<FillTypeMultipleChoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FillTypeMultipleChoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FillTypeMultipleChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
