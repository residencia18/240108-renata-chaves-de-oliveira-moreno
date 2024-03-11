import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroSuinoComponent } from './cadastro-suino.component';

describe('CadastroSuinoComponent', () => {
  let component: CadastroSuinoComponent;
  let fixture: ComponentFixture<CadastroSuinoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CadastroSuinoComponent]
    });
    fixture = TestBed.createComponent(CadastroSuinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
