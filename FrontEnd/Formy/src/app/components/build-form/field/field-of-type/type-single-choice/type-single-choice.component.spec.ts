import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeSingleChoiceComponent } from './type-single-choice.component';

describe('TypeSingleChoiceComponent', () => {
  let component: TypeSingleChoiceComponent;
  let fixture: ComponentFixture<TypeSingleChoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypeSingleChoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypeSingleChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
