import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FillFieldComponent } from './fill-field.component';

describe('FillFieldComponent', () => {
  let component: FillFieldComponent;
  let fixture: ComponentFixture<FillFieldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FillFieldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FillFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
