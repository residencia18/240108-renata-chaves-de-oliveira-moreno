import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { AngularFireDatabase } from '@angular/fire/compat/database';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { FirebaseCodeErrorService } from 'src/app/services/firebase-code-error.service';

@Component({
  selector: 'app-cadastro-gado',
  templateUrl: './cadastro-gado.component.html',
  styleUrls: ['./cadastro-gado.component.css']
})
export class CadastroGadoComponent implements OnInit {
  gadoForm!: FormGroup;
  loading: boolean = false;
  userData: any;
GadoForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private afAuth: AngularFireAuth,
    private db: AngularFireDatabase,
    private toastr: ToastrService,
    private router: Router,
    private firebaseError: FirebaseCodeErrorService
  ) { }

  ngOnInit(): void {
    this.afAuth.authState.subscribe(user => {
      if (user) {
        this.userData = user;
      } else {
        this.router.navigate(['/login']);
      }
    });

    this.gadoForm = this.formBuilder.group({
      anilhaAnimal: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      anilhaPai: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      anilhaMae: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      dataNascimento: ['', Validators.required],
      dataSaida: ['', Validators.required],
      status: ['', Validators.required],
      sexo: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.gadoForm.valid) {
      // Adicionar novo bovino ao Firebase Database
      this.db.list('gados').push(this.gadoForm.value)
        .then(() => {
          // Limpar o formulário após o envio
          this.gadoForm.reset();
          this.toastr.success('Gado cadastrado com sucesso!', 'Sucesso');
        })
        .catch(error => {
          console.error('Erro ao salvar gado:', error);
          this.toastr.error('Erro ao cadastrar gado. Por favor, tente novamente.', 'Erro');
        });
    } else {
      this.toastr.error('Por favor, preencha todos os campos corretamente.', 'Erro');
    }
  }

  logOut() {
    this.afAuth.signOut().then(() => this.router.navigate(['/login']));
  }
}
