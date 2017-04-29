import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeLinearScaleComponent } from './type-linear-scale.component';

describe('TypeLinearScaleComponent', () => {
  let component: TypeLinearScaleComponent;
  let fixture: ComponentFixture<TypeLinearScaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypeLinearScaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypeLinearScaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
