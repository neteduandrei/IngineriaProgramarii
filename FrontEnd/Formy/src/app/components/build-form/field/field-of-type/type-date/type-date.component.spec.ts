import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeDateComponent } from './type-date.component';

describe('TypeDateComponent', () => {
  let component: TypeDateComponent;
  let fixture: ComponentFixture<TypeDateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypeDateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypeDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
