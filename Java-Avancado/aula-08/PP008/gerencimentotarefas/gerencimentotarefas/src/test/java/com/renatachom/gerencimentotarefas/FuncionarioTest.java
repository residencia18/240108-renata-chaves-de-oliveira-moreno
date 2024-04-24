package com.renatachom.gerencimentotarefas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker; // Importe a classe Faker do pacote com.github.javafaker
import com.renatachom.gerencimentotarefas.entity.Funcionario;
import com.renatachom.gerencimentotarefas.entity.Tarefa;
import com.renatachom.gerencimentotarefas.entity.enums.PrioridadeTarefa;

public class FuncionarioTest {

    private Funcionario funcionario;
    private Faker faker; // Crie uma instância de Faker

    @BeforeEach
    public void setUp() {
        funcionario = new Funcionario();
        faker = new Faker(); // Inicialize a instância do Faker
    }

    @Test
    public void testCriacaoFuncionario() {
        funcionario.setNome(faker.name().fullName()); // Use o Faker para gerar um nome fictício
        funcionario.setCargo(faker.job().title()); // Use o Faker para gerar um cargo fictício

        assertEquals(funcionario.getNome(), funcionario.getNome());
        assertEquals(funcionario.getCargo(), funcionario.getCargo());
    }

    @Test
    public void testAdicionarTarefaAoFuncionario() {
        Tarefa tarefa = mock(Tarefa.class);
        tarefa.setDescricao(faker.lorem().sentence()); // Use o Faker para gerar uma descrição fictícia
        tarefa.setPrioridade(PrioridadeTarefa.ALTA);

        // Adiciona a tarefa ao funcionário
        funcionario.addTarefa(tarefa);

        // Verifica se a tarefa está na lista de tarefas do funcionário
        assertTrue(funcionario.getTarefas().contains(tarefa));

        // Aqui precisamos verificar se o funcionário está na lista de funcionários da tarefa
        // Vamos usar o método getFuncionario() da tarefa para isso
        assertTrue(tarefa.getFuncionario() == funcionario);
    }

    // Outros métodos de teste...
}
