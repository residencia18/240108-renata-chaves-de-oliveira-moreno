package com.rechom.avancadojava.repository;


import com.rechom.avancadojava.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
}
