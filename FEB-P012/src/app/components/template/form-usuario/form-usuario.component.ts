import { Component } from '@angular/core';
import { FormBuilder, Validators, FormGroup, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-form-usuario',
  templateUrl: './form-usuario.component.html',
  styleUrls: ['./form-usuario.component.css']
})
export class FormUsuarioComponent {
  userForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.userForm = this.fb.group({
      username: ['', [Validators.required, Validators.maxLength(12), this.noWhitespaceValidator]],
      password: ['', [Validators.required, Validators.minLength(4), this.passwordValidator]],
      email: ['', [Validators.required, Validators.email]],
      fullName: ['', [Validators.required, this.fullNameValidator]],
      phone: ['', [Validators.required, this.phoneValidator]],
      address: ['', Validators.required],
      birthDate: ['', [Validators.required, this.ageValidator]],
      gender: ['', Validators.required],
      profession: ['', Validators.required],
      agreeTerms: [false, Validators.requiredTrue]
    });
  }

  noWhitespaceValidator(control: AbstractControl) {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : { 'whitespace': true };
  }

  passwordValidator(control: AbstractControl) {
    const hasUpperCase = /[A-Z]/.test(control.value);
    const hasSymbol = /\W/.test(control.value);
    const isValid = hasUpperCase && hasSymbol;
    return isValid ? null : { 'password': true };
  }

  fullNameValidator(control: AbstractControl) {
    const hasSpace = /\s/.test(control.value);
    return hasSpace ? null : { 'fullName': true };
  }

  phoneValidator(control: AbstractControl) {
    const isValidPhone = /\(\d{2}\) \d{4,5}-\d{4}/.test(control.value);
    return isValidPhone ? null : { 'phone': true };
  }

  ageValidator(control: AbstractControl) {
    const birthDate = new Date(control.value);
    const ageDifMs = Date.now() - birthDate.getTime();
    const ageDate = new Date(ageDifMs);
    const age = Math.abs(ageDate.getUTCFullYear() - 1970);
    return age >= 18 ? null : { 'age': true };
  }

  onSubmit() {
    if (this.userForm.valid) {
      const user = this.userForm.value;
      console.log(user);
    }
  }
}
