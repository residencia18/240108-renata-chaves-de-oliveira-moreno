import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroGadoComponent } from './cadastro-gado.component';

describe('CadastroGadoComponent', () => {
  let component: CadastroGadoComponent;
  let fixture: ComponentFixture<CadastroGadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastroGadoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CadastroGadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
