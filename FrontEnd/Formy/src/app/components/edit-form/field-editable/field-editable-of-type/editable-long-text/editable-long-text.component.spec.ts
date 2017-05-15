import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditableLongTextComponent } from './editable-long-text.component';

describe('EditableLongTextComponent', () => {
  let component: EditableLongTextComponent;
  let fixture: ComponentFixture<EditableLongTextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditableLongTextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditableLongTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
