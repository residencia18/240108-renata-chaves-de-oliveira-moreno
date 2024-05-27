import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaGadoComponent } from './lista-gado.component';

describe('ListaGadoComponent', () => {
  let component: ListaGadoComponent;
  let fixture: ComponentFixture<ListaGadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListaGadoComponent] // Use 'declarations' para componentes
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListaGadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
