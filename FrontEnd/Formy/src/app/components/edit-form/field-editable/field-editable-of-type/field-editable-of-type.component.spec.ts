import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FieldEditableOfTypeComponent } from './field-editable-of-type.component';

describe('FieldEditableOfTypeComponent', () => {
  let component: FieldEditableOfTypeComponent;
  let fixture: ComponentFixture<FieldEditableOfTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FieldEditableOfTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FieldEditableOfTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
