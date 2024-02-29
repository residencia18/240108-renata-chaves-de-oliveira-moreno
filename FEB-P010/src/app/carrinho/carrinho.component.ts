import { Component } from '@angular/core';
import { ComunicacaoService } from '../communication.service';

@Component({
  selector: 'app-carrinho',
  standalone: true,
  imports: [],
  templateUrl: './carrinho.component.html',
  styleUrl: './carrinho.component.css'
})
export class CarrinhoComponent {
  constructor(private comunicacaoService: ComunicacaoService) {
    this.comunicacaoService.veiculoObservable$.subscribe(veiculo => {
      // Lógica para lidar com o veículo recebido
    });
  }
}
