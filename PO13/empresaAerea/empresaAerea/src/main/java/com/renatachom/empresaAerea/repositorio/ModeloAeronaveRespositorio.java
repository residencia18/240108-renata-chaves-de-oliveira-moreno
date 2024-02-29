package com.renatachom.empresaAerea.repositorio;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatachom.empresaAerea.Model.ModeloAeronave;

public interface ModeloAeronaveRespositorio extends JpaRepository<ModeloAeronave, Long>{

	ArrayList<ModeloAeronave> findAll();

}