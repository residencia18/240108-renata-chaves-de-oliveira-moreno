import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ManejoService } from '../../services/manejo.service';
import { ToastrService } from 'ngx-toastr';

interface Sessao {
  data: Date;
  descricao: string;
  animais: string[];
  atividadesPlanejadas: string;
}

@Component({
  selector: 'app-manejo-sanitario',
  templateUrl: './manejo-sanitario.component.html',
  styleUrls: ['./manejo-sanitario.component.css']
})
export class ManejoSanitarioComponent {
  mensagem: string = '';
  novaVacina: string = '';
  vacinas: string[] = [];
  sessoes: Sessao[] = [];

  constructor(private manejoService: ManejoService, private toastr: ToastrService) {}

  submitForm(manejoForm: NgForm) {
    const sessao: Sessao = {
      data: manejoForm.value.data,
      descricao: manejoForm.value.descricao,
      animais: manejoForm.value.animais.split(',').map((animal: string) => animal.trim()),
      atividadesPlanejadas: manejoForm.value.atividadesPlanejadas
    };

    this.sessoes.push(sessao); // Adiciona a nova sessão ao array de sessões

    this.manejoService.salvarSessao(sessao).subscribe((response: any) => {
      console.log('Sessão salva com sucesso!', response);
      this.toastr.success('Sessão salva com sucesso!'); // Exibe uma mensagem de sucesso
      manejoForm.resetForm(); // Limpa o formulário após o envio bem-sucedido
    }, (error: any) => {
      console.error('Erro ao salvar sessão:', error);
      this.toastr.error('Erro ao salvar sessão.'); // Exibe uma mensagem de erro
    });
  }

  adicionarVacina() {
    this.vacinas.push(this.novaVacina);
    this.novaVacina = ''; // Limpar o campo de novaVacina após adicionar a vacina
  }

  removeVacina(index: number) {
    this.vacinas.splice(index, 1);
  }
}

