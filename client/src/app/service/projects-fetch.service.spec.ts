import { TestBed } from '@angular/core/testing';

import { ProjectsFetchService } from './projects-fetch.service';

describe('ProjectsFetchService', () => {
  let service: ProjectsFetchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjectsFetchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
