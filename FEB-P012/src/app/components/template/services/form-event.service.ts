// form-event.service.ts

import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FormEventService {
  formData: any = {
    values: {},
    statuses: {}
  };

  constructor() { }

  watchFormChanges(form: FormGroup) {
    form.valueChanges.subscribe(values => {
      this.formData.values = values;
    });

    form.statusChanges.subscribe(status => {
      this.formData.statuses = status;
    });
  }

  // Outros métodos conforme necessário
}
