import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditableShortTextComponent } from './editable-short-text.component';

describe('EditableShortTextComponent', () => {
  let component: EditableShortTextComponent;
  let fixture: ComponentFixture<EditableShortTextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditableShortTextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditableShortTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
