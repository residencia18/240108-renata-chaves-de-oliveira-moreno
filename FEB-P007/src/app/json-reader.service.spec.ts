import { TestBed } from '@angular/core/testing';

import { JsonReaderService } from './json-reader.service';

describe('JsonReaderService', () => {
  let service: JsonReaderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JsonReaderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
