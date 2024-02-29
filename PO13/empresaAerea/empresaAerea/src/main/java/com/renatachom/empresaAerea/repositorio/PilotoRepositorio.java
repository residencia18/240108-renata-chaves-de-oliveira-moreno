package com.renatachom.empresaAerea.repositorio;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatachom.empresaAerea.Model.Piloto;

public interface PilotoRepositorio extends JpaRepository<Piloto, Long> {

	ArrayList<Piloto> findAll();

}