import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FillTypeSingleChoiceComponent } from './fill-type-single-choice.component';

describe('FillTypeSingleChoiceComponent', () => {
  let component: FillTypeSingleChoiceComponent;
  let fixture: ComponentFixture<FillTypeSingleChoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FillTypeSingleChoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FillTypeSingleChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
