package com.renatachom.gerencimentotarefas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarefaFuncionariosController {

    @GetMapping("/tarefa_funcionarios")
    public String getTarefaFuncionarios() {
        // Lógica para buscar e retornar os dados dos funcionários relacionados às tarefas
        return "Aqui você pode retornar os dados dos funcionários relacionados às tarefas.";
    }
}
