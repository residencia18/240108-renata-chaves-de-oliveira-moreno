package com.residencia18.renatachom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia18.renatachom.Funcionario;
import com.residencia18.renatachom.model.FuncionarioModel;
import com.residencia18.renatachom.repository.FuncionarioRepository;
import com.residencia18.renatachom.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @Override
    public void cadastrarFuncionario(FuncionarioModel funcionario) { // Corrigindo o tipo do parâmetro
        funcionarioRepository.save(funcionario);
    }
    
    @Override
    public FuncionarioModel buscarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

}
