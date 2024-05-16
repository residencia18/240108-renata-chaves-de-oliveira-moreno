// tarefa.model.ts

export interface Tarefa {
    id: string;
    descricao: string;
}

export interface TarefaState {
    tarefas: Tarefa[];
}
