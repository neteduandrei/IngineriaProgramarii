import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeMultipleChoiceComponent } from './type-multiple-choice.component';

describe('TypeMultipleChoiceComponent', () => {
  let component: TypeMultipleChoiceComponent;
  let fixture: ComponentFixture<TypeMultipleChoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypeMultipleChoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypeMultipleChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
