import { TestBed, inject } from '@angular/core/testing';

import { BuildFormService } from './build-form.service';

describe('BuildFormService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BuildFormService]
    });
  });

  it('should ...', inject([BuildFormService], (service: BuildFormService) => {
    expect(service).toBeTruthy();
  }));
});
