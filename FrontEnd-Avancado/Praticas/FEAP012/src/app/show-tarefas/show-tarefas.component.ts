import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { TarefaState } from '../store/tarefa.reducer';
import { selectorSelecionaTarefa } from '../store/tarefa.seletors';
import { Tarefa } from '../tarefa.model';
import { removerTarefa, atualizarTarefa } from '../store/tarefa.actions';
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-show-tarefas',
  standalone: true,
  templateUrl: './show-tarefas.component.html',
  imports: [CommonModule, FormsModule],
  styleUrls: ['./show-tarefas.component.css']
})
export class ShowTarefasComponent {
  tarefas: Tarefa[] = [];
  tasks$!: Observable<TarefaState>;
  tarefaSelecionadaId: string | null = null;
  novaDescricao: string = '';

  constructor(private store: Store<{ tarefas: TarefaState }>) { }

  ngOnInit() {
    this.tasks$ = this.store.select(selectorSelecionaTarefa);
    this.tasks$.subscribe((t) => {
      this.tarefas = t.tarefas;
    });
  }

  removeTarefa(id: string) {
    this.store.dispatch(removerTarefa({ id: id }));
  }

  selecionarTarefa(id: string) {
    this.tarefaSelecionadaId = id;
    const tarefaSelecionada = this.tarefas.find(t => t.id === id);
    if (tarefaSelecionada) {
      this.novaDescricao = tarefaSelecionada.descricao;
    }
  }

  salvarAtualizacao() {
    if (this.tarefaSelecionadaId && this.novaDescricao.trim() !== '') {
      this.store.dispatch(atualizarTarefa({ id: this.tarefaSelecionadaId, novaDescricao: this.novaDescricao }));
      this.tarefaSelecionadaId = null;
      this.novaDescricao = '';
    }
  }
}