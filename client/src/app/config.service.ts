import { Injectable } from '@angular/core';

@Injectable()
export class ConfigService {

  constructor() { }

  getBaseUrl(): string {
    return 'http://localhost:8080/alepe';
  }

}
