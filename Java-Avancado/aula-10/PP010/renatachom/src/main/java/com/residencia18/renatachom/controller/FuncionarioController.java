package com.residencia18.renatachom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.residencia18.renatachom.model.FuncionarioModel;
import com.residencia18.renatachom.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario") // Define o prefixo para todas as rotas neste controlador
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;
    
    @PostMapping("/cadastrar") // Endpoint para cadastrar um funcionário via POST
    public ResponseEntity<?> cadastrarFuncionario(@RequestBody FuncionarioModel funcionario){
        funcionarioService.cadastrarFuncionario(funcionario);
        return new ResponseEntity<>("Funcionário cadastrado com sucesso!", HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}") // Endpoint para buscar um funcionário pelo ID via GET
    public ResponseEntity<FuncionarioModel> buscarFuncionarioPorId(@PathVariable Long id){
        FuncionarioModel funcionario = funcionarioService.buscarFuncionarioPorId(id);
        if (funcionario != null){
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

