import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FillTypeLinearScaleComponent } from './fill-type-linear-scale.component';

describe('FillTypeLinearScaleComponent', () => {
  let component: FillTypeLinearScaleComponent;
  let fixture: ComponentFixture<FillTypeLinearScaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FillTypeLinearScaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FillTypeLinearScaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
