import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SimplenavbarComponent } from './simplenavbar.component';

describe('SimplenavbarComponent', () => {
  let component: SimplenavbarComponent;
  let fixture: ComponentFixture<SimplenavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SimplenavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SimplenavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
