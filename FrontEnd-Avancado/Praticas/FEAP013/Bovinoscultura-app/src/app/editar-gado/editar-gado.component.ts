import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Gado } from '../gado.model'; 

@Component({
  selector: 'app-editar-gado',
  templateUrl: './editar-gado.component.html',
  styleUrls: ['./editar-gado.component.css']
})
export class EditarGadoComponent implements OnInit {
  gadoForm!: FormGroup;
  gadoSelecionada: Gado | null = null; // Declare a variável para a ave selecionada

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.gadoForm = this.formBuilder.group({
      anilhaAnimal: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      anilhaPai: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      anilhaMae: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      dataNascimento: ['', Validators.required],
      dataSaida: ['', Validators.required],
      status: ['', Validators.required],
      sexo: ['', Validators.required]
    });

    // Carregar os dados do bovino selecionada no formulário de edição
    if (this.gadoSelecionada) {
      this.gadoForm.patchValue({
        anilhaAnimal: this.gadoSelecionada.anilhaAnimal,
        anilhaPai: this.gadoSelecionada.anilhaPai,
        anilhaMae: this.gadoSelecionada.anilhaMae,
        dataNascimento: this.gadoSelecionada.dataNascimento,
        dataSaida: this.gadoSelecionada.dataSaida,
        status: this.gadoSelecionada.status,
        sexo: this.gadoSelecionada.sexo
      });
    }
  }

  salvarEdicao() {
    // Implemente a lógica para salvar as alterações do bovino
  }

  cancelarEdicao() {
    // Implemente a lógica para cancelar a edição
  }
}
