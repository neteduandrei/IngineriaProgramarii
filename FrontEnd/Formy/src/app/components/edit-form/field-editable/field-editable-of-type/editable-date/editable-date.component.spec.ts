import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditableDateComponent } from './editable-date.component';

describe('EditableDateComponent', () => {
  let component: EditableDateComponent;
  let fixture: ComponentFixture<EditableDateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditableDateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditableDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
