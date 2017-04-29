import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeLongTextComponent } from './type-long-text.component';

describe('TypeLongTextComponent', () => {
  let component: TypeLongTextComponent;
  let fixture: ComponentFixture<TypeLongTextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypeLongTextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypeLongTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
