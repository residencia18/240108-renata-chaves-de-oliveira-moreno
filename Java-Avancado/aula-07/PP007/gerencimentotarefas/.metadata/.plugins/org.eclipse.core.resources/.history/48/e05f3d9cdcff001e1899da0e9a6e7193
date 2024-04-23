package com.renatachom.gerencimentotarefas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.renatachom.gerencimentotarefas.entity.Funcionario;
import com.renatachom.gerencimentotarefas.entity.Tarefa;
import com.renatachom.gerencimentotarefas.entity.enums.PrioridadeTarefa;

public class TarefaTest {

    @Test
    public void testCriacaoTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Implementar recurso X");
        tarefa.setDescricao("Desenvolver a funcionalidade X");
        tarefa.setPrioridade(PrioridadeTarefa.ALTA); // Utiliza PrioridadeTarefa.ALTA em vez de uma String

        assertEquals("Implementar recurso X", tarefa.getTitulo());
        assertEquals("Desenvolver a funcionalidade X", tarefa.getDescricao());
        assertEquals(PrioridadeTarefa.ALTA, tarefa.getPrioridade());
    }

    @Test
    public void testAssociacaoFuncionarioTarefa() {
        Funcionario funcionario = new Funcionario();
        Tarefa tarefa = new Tarefa();

        tarefa.setFuncionario(funcionario);

        assertEquals(funcionario, tarefa.getFuncionario());
        assertTrue(funcionario.getTarefas().contains(tarefa));
    }

    // Outros métodos de teste...
}

