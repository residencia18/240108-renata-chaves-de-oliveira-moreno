import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr'; // Importe o ToastrService para exibir mensagens de notificação

@Component({
  selector: 'app-cadastro-suino',
  templateUrl: './cadastro-suino.component.html',
  styleUrls: ['./cadastro-suino.component.css']
})
export class CadastroSuinoComponent implements OnInit {
  cadastroSuinoForm: FormGroup; 

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private toastr: ToastrService // Injete o ToastrService
  ) { 
    this.cadastroSuinoForm = this.formBuilder.group({
      brincoAnimal: ['', Validators.required],
      brincoPai: ['', Validators.required],
      brincoMae: ['', Validators.required],
      dataNascimento: ['', Validators.required],
      dataSaida: ['', Validators.required],
      status: ['', Validators.required],
      sexo: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    // ...
  }

  submitForm() {
    if (this.cadastroSuinoForm.invalid) {
      return;
    }

    const formData = this.cadastroSuinoForm.value;
    this.http.post('https://suinocultura-a16ad-default-rtdb.firebaseio.com/suinos.json', formData).subscribe(response => {
      console.log('Formulário enviado com sucesso!', response);
      this.toastr.success('Formulário enviado com sucesso!'); // Exibe uma mensagem de sucesso
      // Limpar o formulário após o envio bem-sucedido, se necessário
      this.cadastroSuinoForm.reset();
    }, error => {
      console.error('Erro ao enviar formulário:', error);
      this.toastr.error('Erro ao enviar formulário.'); // Exibe uma mensagem de erro
    });
  }
}
