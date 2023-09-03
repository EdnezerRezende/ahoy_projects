import { TestBed } from '@angular/core/testing';

import { AhoyService } from './ahoy.service';

describe('AhoyService', () => {
  let service: AhoyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AhoyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
