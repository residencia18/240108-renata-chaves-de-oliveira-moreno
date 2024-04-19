package com.renatachom.gerencimentotarefas.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.renatachom.gerencimentotarefas.entity.Funcionario;
import com.renatachom.gerencimentotarefas.service.FuncionarioService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable Long id) {
        try {
            Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
            return ResponseEntity.ok(funcionario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario adicionarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.adicionarFuncionario(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioAtualizado) {
        try {
            Funcionario funcionario = funcionarioService.atualizarFuncionario(id, funcionarioAtualizado);
            return ResponseEntity.ok(funcionario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable Long id) {
        funcionarioService.excluirFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
