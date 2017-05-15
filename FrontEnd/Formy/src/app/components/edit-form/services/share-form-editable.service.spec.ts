import { TestBed, inject } from '@angular/core/testing';

import { ShareFormEditableService } from './share-form-editable.service';

describe('ShareFormEditableService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ShareFormEditableService]
    });
  });

  it('should ...', inject([ShareFormEditableService], (service: ShareFormEditableService) => {
    expect(service).toBeTruthy();
  }));
});
