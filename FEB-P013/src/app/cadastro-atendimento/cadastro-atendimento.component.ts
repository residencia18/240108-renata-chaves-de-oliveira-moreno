// cadastro-atendimento.component.ts

import { Component } from '@angular/core';
import { AtendimentoService } from '../atendimento.service';

@Component({
  selector: 'app-cadastro-atendimento',
  templateUrl: './cadastro-atendimento.component.html',
  styleUrls: ['./cadastro-atendimento.component.css']
})
export class CadastroAtendimentoComponent {
  nomePet!: string;
  tipoPet!: string;
  dataAtendimento!: string;
  observacoes!: string;

  constructor(private atendimentoService: AtendimentoService) { }

  submitForm() {
    const novoAtendimento = {
      nomePet: this.nomePet,
      tipoPet: this.tipoPet,
      dataAtendimento: this.dataAtendimento,
      observacoes: this.observacoes
    };

    this.atendimentoService.cadastrarAtendimento(novoAtendimento).subscribe(
      (resultado: any) => {
        console.log('Atendimento cadastrado com sucesso:', resultado);
      },
      (erro: any) => {
        console.error('Erro ao cadastrar atendimento:', erro);
      }
    );
  }
}
