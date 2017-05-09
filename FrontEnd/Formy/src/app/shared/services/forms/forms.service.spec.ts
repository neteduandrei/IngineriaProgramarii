import { TestBed, inject } from '@angular/core/testing';

import { FormsService } from './forms.service';

describe('FormsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FormsService]
    });
  });

  it('should ...', inject([FormsService], (service: FormsService) => {
    expect(service).toBeTruthy();
  }));
});
