import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarrinhoComprasComponent } from './carrinho-compras.components';

describe('CarrinhoComprasComponent', () => {
  let component: CarrinhoComprasComponent;
  let fixture: ComponentFixture<CarrinhoComprasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CarrinhoComprasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CarrinhoComprasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});