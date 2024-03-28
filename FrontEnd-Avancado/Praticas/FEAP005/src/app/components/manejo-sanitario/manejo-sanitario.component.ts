import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ManejoService } from '../../services/manejo.service';
import { ToastrService } from 'ngx-toastr';

//  interface AtividadePlanejada
interface AtividadePlanejada {
  data: Date;
  descricao: string;
  animal: string;
  vacina: string;
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


  constructor(private manejoService: ManejoService, private toastr: ToastrService) {}

  submitForm(manejoForm: NgForm) {
    const atividade: AtividadePlanejada = {
      data: manejoForm.value.data,
      descricao: manejoForm.value.descricao,
      animal: manejoForm.value.animal,
      //vacina: manejoForm.value.vacina
      vacina: this.vacinas.join(', ')
    };

    this.manejoService.salvarAtividade(atividade).subscribe(response => {
      console.log('Dados salvos com sucesso!', response);
      this.toastr.success('Dados salvos com sucesso!'); // Exibe uma mensagem de sucesso
      manejoForm.resetForm(); // Limpar o formulário após o envio bem-sucedido
    }, error => {
      console.error('Erro ao salvar dados:', error);
      this.toastr.error('Erro ao salvar dados.'); // Exibe uma mensagem de erro
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
