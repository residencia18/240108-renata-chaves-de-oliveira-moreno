import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GadoService } from '../gado.service';
import { PesoService } from '../peso.service'; 
import { ToastrService } from 'ngx-toastr'; 

@Component({
  selector: 'app-cadastro-peso',
  templateUrl: './cadastro-peso.component.html',
  styleUrls: ['./cadastro-peso.component.css']
})
export class CadastroPesoComponent implements OnInit {
  pesoForm: FormGroup;
  anilhasPai: string[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private gadoService: GadoService,
    private pesoService: PesoService, 
    private toastr: ToastrService 
    
    
  ) {
    this.pesoForm = this.formBuilder.group({
      anilhaPai: ['', Validators.required],
      dataPesagem: ['', Validators.required],
      pesoKg: ['', [Validators.required, Validators.pattern(/^\d*\.?\d*$/)]]
    });
  }

  ngOnInit() {
    this.gadoService.obterAnilhasPai().subscribe(anilhas => {
      this.anilhasPai = anilhas;
    });
  }
  
  submitForm() {
    if (this.pesoForm.valid) {
      this.pesoService.cadastrarPeso(this.pesoForm.value).subscribe(
        (response: any) => { 
          console.log('Peso cadastrado com sucesso:', response);
          this.toastr.success('Peso cadastrado com sucesso!', 'Sucesso');
          this.pesoForm.reset();
        },
        (error: any) => {
          console.error('Erro ao cadastrar peso:', error);
          this.toastr.error('Erro ao cadastrar peso. Por favor, tente novamente.', 'Erro');
        }
      );
    } else {
      this.toastr.error('Por favor, preencha o formulário corretamente.', 'Erro');
    }
  }
}