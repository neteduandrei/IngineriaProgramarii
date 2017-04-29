import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FieldOfTypeComponent } from './field-of-type.component';

describe('FieldOfTypeComponent', () => {
  let component: FieldOfTypeComponent;
  let fixture: ComponentFixture<FieldOfTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FieldOfTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FieldOfTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
