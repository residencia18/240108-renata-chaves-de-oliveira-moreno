package com.renatachom.empresaAerea.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatachom.empresaAerea.Model.Aeroporto;

public interface AeroportoRepositorio extends JpaRepository<Aeroporto, Long>{

}