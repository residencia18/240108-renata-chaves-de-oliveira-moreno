import { Component } from '@angular/core';
import { HistoricoAnimalService } from '../../services/historico-animal.service';

@Component({
  selector: 'app-controle-porcos',
  templateUrl: './controle-porcos.component.html',
  styleUrls: ['./controle-porcos.component.css']
})
export class ControlePorcosComponent {
  brinco: number = 0;
  historico: any[] = [];

  constructor(private historicoService: HistoricoAnimalService) { }

  listarHistorico() {
    this.historicoService.getHistoricoAnimal(this.brinco).subscribe((data: any[]) => {
      this.historico = data;
    });
  }
}
