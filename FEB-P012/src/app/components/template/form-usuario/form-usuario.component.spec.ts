import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormUsuarioComponent } from './form-usuario.component';

describe('FormUsuarioComponent', () => {
  let component: FormUsuarioComponent;
  let fixture: ComponentFixture<FormUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FormUsuarioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
