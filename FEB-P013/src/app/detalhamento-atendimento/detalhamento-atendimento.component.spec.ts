import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalhamentoAtendimentoComponent } from './detalhamento-atendimento.component';

describe('DetalhamentoAtendimentoComponent', () => {
  let component: DetalhamentoAtendimentoComponent;
  let fixture: ComponentFixture<DetalhamentoAtendimentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DetalhamentoAtendimentoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetalhamentoAtendimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
