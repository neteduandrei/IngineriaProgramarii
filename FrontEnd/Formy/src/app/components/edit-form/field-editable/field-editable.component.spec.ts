import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FieldEditableComponent } from './field-editable.component';

describe('FieldEditableComponent', () => {
  let component: FieldEditableComponent;
  let fixture: ComponentFixture<FieldEditableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FieldEditableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FieldEditableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
