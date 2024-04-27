import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { Store } from '@ngrx/store';
import { TarefaState } from './store/tarefa.reducer';
import { Observable } from 'rxjs';
import { selectorSelecionaTarefa } from './store/tarefa.seletors';
import { InputTarefaComponent } from './input-tarefa/input-tarefa.component';
import { ShowTarefasComponent } from './show-tarefas/show-tarefas.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, InputTarefaComponent, ShowTarefasComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'NgRxV2';
  tarefas$: Observable<TarefaState>;

  constructor(private store: Store<{tarefas: TarefaState}>){
    this.tarefas$ = store.select(selectorSelecionaTarefa);
  }
}

/*  
export const selectorContador = (estado: {contador: number}) => estado.contador;
contador$: Observable<number>;

  constructor(private store:Store<{contador:number}>) { 
    this.contador$ = store.select(selectorContador);
  }
   */