import { TestBed, inject } from '@angular/core/testing';

import { FillFormService } from './fill-form.service';

describe('FillFormService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FillFormService]
    });
  });

  it('should ...', inject([FillFormService], (service: FillFormService) => {
    expect(service).toBeTruthy();
  }));
});
