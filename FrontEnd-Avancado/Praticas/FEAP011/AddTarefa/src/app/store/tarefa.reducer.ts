import { createReducer, on } from '@ngrx/store';
import { Tarefa } from '../tarefa.model';
import { adicionarTarefa, removerTarefa, atualizarTarefa } from './tarefa.actions';

export interface TarefaState {
    tarefas: Tarefa[];
}

const estadoSalvo = localStorage.getItem('tarefasEstado');
const estadoInicial: TarefaState = estadoSalvo ? JSON.parse(estadoSalvo) : { tarefas: [] };

export const tarefasReducer = createReducer(
    estadoInicial,
    on(adicionarTarefa, (estado: TarefaState, { tarefa }) => {
        const newState = { ...estado, tarefas: [...estado.tarefas, tarefa] };
        localStorage.setItem('tarefasEstado', JSON.stringify(newState));
        return newState;
    }),
    on(removerTarefa, (estado: TarefaState, { id }) => {
        const newState = { ...estado, tarefas: estado.tarefas.filter(t => t.id !== id) };
        localStorage.setItem('tarefasEstado', JSON.stringify(newState));
        return newState;
    }),
    on(atualizarTarefa, (estado: TarefaState, { id, novaDescricao }) => {
        const newState = {
            ...estado,
            tarefas: estado.tarefas.map(tarefa => tarefa.id === id ? { ...tarefa, descricao: novaDescricao } : tarefa)
        };
        localStorage.setItem('tarefasEstado', JSON.stringify(newState));
        return newState;
    })
);
