package com.renatachom.gerencimentotarefas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.renatachom.gerencimentotarefas.entity.Funcionario;
import com.renatachom.gerencimentotarefas.entity.Tarefa;
import com.renatachom.gerencimentotarefas.entity.enums.PrioridadeTarefa;

public class FuncionarioTest {

    @Test
    public void testCriacaoFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("João");
        funcionario.setCargo("Desenvolvedor");

        assertEquals("João", funcionario.getNome());
        assertEquals("Desenvolvedor", funcionario.getCargo());
    }

    @Test
    public void testAdicionarTarefaAoFuncionario() {
        Funcionario funcionario = new Funcionario();
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao("Implementar recurso X");
        tarefa.setPrioridade(PrioridadeTarefa.ALTA); // Corrigido para usar PrioridadeTarefa.ALTA

        funcionario.addTarefa(tarefa);

        assertTrue(funcionario.getTarefas().contains(tarefa));
        assertEquals(funcionario, tarefa.getFuncionario());
    }

    // Outros métodos de teste...
}
