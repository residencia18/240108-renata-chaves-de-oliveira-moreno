import { Component } from '@angular/core';
import { ComunicacaoService } from '../communication.service';

@Component({
  selector: 'app-objetos',
  standalone: true,
  imports: [],
  templateUrl: './objetos.component.html',
  styleUrl: './objetos.component.css'
})
export class ObjetosComponent {
  constructor(private comunicacaoService: ComunicacaoService) {}

  selecionarVeiculo(veiculo: any) {
    this.comunicacaoService.enviarVeiculo(veiculo);
  }
}
