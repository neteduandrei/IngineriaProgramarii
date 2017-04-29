import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeShortTextComponent } from './type-short-text.component';

describe('TypeShortTextComponent', () => {
  let component: TypeShortTextComponent;
  let fixture: ComponentFixture<TypeShortTextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypeShortTextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypeShortTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
