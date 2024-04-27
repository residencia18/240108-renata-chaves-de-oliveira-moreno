import { TarefaState } from './tarefa.reducer';

export const selectorSelecionaTarefa = (estado: { tarefas: TarefaState }) => estado.tarefas;
