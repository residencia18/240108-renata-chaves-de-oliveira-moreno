import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListagemAtendimentosComponent } from './listagem-atendimentos.component';

describe('ListagemAtendimentosComponent', () => {
  let component: ListagemAtendimentosComponent;
  let fixture: ComponentFixture<ListagemAtendimentosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListagemAtendimentosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListagemAtendimentosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
