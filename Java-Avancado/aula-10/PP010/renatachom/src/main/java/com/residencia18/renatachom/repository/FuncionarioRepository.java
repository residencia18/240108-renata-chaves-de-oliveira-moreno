package com.residencia18.renatachom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia18.renatachom.model.FuncionarioModel;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
    boolean existsByNome(String nome);
}
