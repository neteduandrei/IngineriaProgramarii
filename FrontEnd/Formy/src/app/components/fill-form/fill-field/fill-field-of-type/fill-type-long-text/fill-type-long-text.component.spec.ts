import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FillTypeLongTextComponent } from './fill-type-long-text.component';

describe('FillTypeLongTextComponent', () => {
  let component: FillTypeLongTextComponent;
  let fixture: ComponentFixture<FillTypeLongTextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FillTypeLongTextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FillTypeLongTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
