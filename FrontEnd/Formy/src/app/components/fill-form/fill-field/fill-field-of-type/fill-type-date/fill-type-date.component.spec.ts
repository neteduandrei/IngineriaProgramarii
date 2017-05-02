import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FillTypeDateComponent } from './fill-type-date.component';

describe('FillTypeDateComponent', () => {
  let component: FillTypeDateComponent;
  let fixture: ComponentFixture<FillTypeDateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FillTypeDateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FillTypeDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
