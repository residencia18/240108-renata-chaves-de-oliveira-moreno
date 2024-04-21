package com.renatachom.gerencimentotarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.renatachom.gerencimentotarefas.entity.Funcionario;
import com.renatachom.gerencimentotarefas.service.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/funcionarios")
@Api(tags = "Funcionários")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    @ApiOperation("Listar todos os funcionários")
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar funcionário por ID")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(
            @ApiParam(value = "ID do funcionário", required = true) @PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        return ResponseEntity.ok(funcionario);
    }

    @PostMapping
    @ApiOperation("Adicionar um novo funcionário")
    public ResponseEntity<Funcionario> adicionarFuncionario(
            @ApiParam(value = "Dados do novo funcionário", required = true) @RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.adicionarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualizar um funcionário existente")
    public ResponseEntity<Funcionario> atualizarFuncionario(
            @ApiParam(value = "ID do funcionário a ser atualizado", required = true) @PathVariable Long id,
            @ApiParam(value = "Novos dados do funcionário", required = true) @RequestBody Funcionario funcionarioAtualizado) {
        Funcionario funcionario = funcionarioService.atualizarFuncionario(id, funcionarioAtualizado);
        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Excluir um funcionário")
    public ResponseEntity<Void> excluirFuncionario(
            @ApiParam(value = "ID do funcionário a ser excluído", required = true) @PathVariable Long id) {
        funcionarioService.excluirFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
