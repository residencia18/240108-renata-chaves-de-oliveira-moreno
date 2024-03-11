import { TestBed } from '@angular/core/testing';

import { SuinoService } from './suino.service';

describe('SuinoService', () => {
  let service: SuinoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SuinoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
