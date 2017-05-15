import { TestBed, async, inject } from '@angular/core/testing';

import { EditFormGuard } from './edit-form.guard';

describe('EditFormGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EditFormGuard]
    });
  });

  it('should ...', inject([EditFormGuard], (guard: EditFormGuard) => {
    expect(guard).toBeTruthy();
  }));
});
