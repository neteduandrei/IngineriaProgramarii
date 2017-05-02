import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FillFieldOfTypeComponent } from './fill-field-of-type.component';

describe('FillFieldOfTypeComponent', () => {
  let component: FillFieldOfTypeComponent;
  let fixture: ComponentFixture<FillFieldOfTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FillFieldOfTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FillFieldOfTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
