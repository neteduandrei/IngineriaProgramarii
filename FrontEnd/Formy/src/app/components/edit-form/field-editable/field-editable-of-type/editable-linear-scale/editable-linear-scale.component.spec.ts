import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditableLinearScaleComponent } from './editable-linear-scale.component';

describe('EditableLinearScaleComponent', () => {
  let component: EditableLinearScaleComponent;
  let fixture: ComponentFixture<EditableLinearScaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditableLinearScaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditableLinearScaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
