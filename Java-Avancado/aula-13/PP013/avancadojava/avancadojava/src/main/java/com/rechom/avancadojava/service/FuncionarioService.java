package com.rechom.avancadojava.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rechom.avancadojava.entity.Funcionario;
import com.rechom.avancadojava.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

   
}
