import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FillTypeShortTextComponent } from './fill-type-short-text.component';

describe('FillTypeShortTextComponent', () => {
  let component: FillTypeShortTextComponent;
  let fixture: ComponentFixture<FillTypeShortTextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FillTypeShortTextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FillTypeShortTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
