package com.residencia18.renatachom.service;

import com.residencia18.renatachom.model.FuncionarioModel;

public interface FuncionarioService {
    void cadastrarFuncionario(FuncionarioModel funcionario);

	FuncionarioModel buscarFuncionarioPorId(Long id);
}
