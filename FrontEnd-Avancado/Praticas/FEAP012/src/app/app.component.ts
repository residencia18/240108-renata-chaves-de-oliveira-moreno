// app.component.ts
import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { TarefaState } from './store/tarefa.reducer';
import { Observable } from 'rxjs';
import { selectorSelecionaTarefa } from './store/tarefa.seletors';
import { Tarefa } from './tarefa.model';
import { adicionarTarefa, removerTarefa } from './store/tarefa.actions';
import {ShowTarefasComponent} from "./show-tarefas/show-tarefas.component";
import {InputTarefaComponent} from "./input-tarefa/input-tarefa.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: true,
  imports: [
    ShowTarefasComponent,
    InputTarefaComponent
  ],
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'NgRxV2';
  tarefas$: Observable<TarefaState>;

  constructor(private store: Store<{tarefas: TarefaState}>) {
    this.tarefas$ = store.select(selectorSelecionaTarefa);
  }

  adicionarTarefa(descricao: string) {
    const tarefa: Tarefa = { id: this.generateId(), descricao };
    this.store.dispatch(adicionarTarefa({ tarefa }));
  }

  removerTarefa(id: string) {
    this.store.dispatch(removerTarefa({ id }));
  }

  private generateId() {
    return Date.now().toString(36) + Math.random().toString(36).substring(2);
  }
}
