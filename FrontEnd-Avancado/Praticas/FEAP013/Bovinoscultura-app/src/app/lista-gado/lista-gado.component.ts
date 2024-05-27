import { Component, OnInit } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/compat/database';
import { ToastrService } from 'ngx-toastr';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-gado',
  templateUrl: './lista-gado.component.html',
  styleUrls: ['./lista-gado.component.css']
})
export class ListaGadoComponent implements OnInit {
  gado: any[] = [];
  gadoFiltrado: any[] = [];
  gadoSelecionada: any = null;
  filtroAnilhaPai: string = '';
  userData: any;
  userEmail: string = '';

  constructor(
    private db: AngularFireDatabase,
    private afAuth: AngularFireAuth,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.afAuth.currentUser.then(user => {
      if (user && user.emailVerified) {
        this.userData = user;
        this.userEmail = user?.email ?? '';
      } else {
        this.router.navigate(['/login']);
      }
    });

    this.carregarGado();
  }

  carregarGado() {
    const gadoRef = this.db.list('gados');
    gadoRef.snapshotChanges().subscribe((gado: any[]) => {
      this.gado = gado.map((gado: any) => {
        return { id: gado.payload.key, ...gado.payload.val() };
      });
      // Verifica se há filtro, se não houver, exibe todos os bovinos
      if (!this.filtroAnilhaPai.trim()) {
        this.gadoFiltrado = this.gado;
      }
    }, error => {
      console.error('Erro ao carregar dados do Firebase:', error);
    });
  }

  pesquisarPorAnilhaPai() {
    const filtro = this.filtroAnilhaPai.trim();
    console.log('Pesquisando por:', filtro);
    if (filtro !== '') {
      // Filtra os gados com base no filtro de anilha do pai
      this.gadoFiltrado = this.gado.filter(gado => gado.anilhaPai && gado.anilhaPai.toString() === filtro);
      console.log('Bovinos filtrados:', this.gadoFiltrado);
    } else {
      // Se o filtro estiver vazio, exibe todos os bovinos
      console.log('Filtro vazio, exibindo todos os bovinos');
      this.gadoFiltrado = this.gado;
    }
  }
  

  editarGado(gado: any) {
    this.gadoSelecionada = { ...gado };
  }

  salvarEdicao() {
    const gadoRef = this.db.object(`gado/${this.gadoSelecionada.id}`);
    gadoRef.update(this.gadoSelecionada)
      .then(() => {
        this.toastr.success('Bovino editado com sucesso!', 'Sucesso');
        this.gadoSelecionada = null;
      })
      .catch(error => {
        console.error(error);
        this.toastr.error('Ocorreu um erro ao editar o bovino.', 'Erro');
      });
  }

  voltarListaGado() {
    this.gadoSelecionada = null;
  }

  deletarGado(gado: any) {
    if (confirm('Tem certeza de que deseja excluir este bovino?')) {
      const gadoRef = this.db.object(`gado/${gado.id}`);
      gadoRef.remove()
        .then(() => {
          this.toastr.success('Bovino excluído com sucesso!', 'Sucesso');
        })
        .catch(error => {
          console.error(error);
          this.toastr.error('Ocorreu um erro ao excluir o bovino.', 'Erro');
        });
    }
  }

  logOut() {
    this.afAuth.signOut().then(() => this.router.navigate(['/login']));
  }
}
