package com.danielmonteiro.leilao.repositorio;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielmonteiro.leilao.modelo.Lance;
import com.danielmonteiro.leilao.modelo.Leilao;

public interface LanceRepositorio extends JpaRepository<Lance, Long>{

	ArrayList<Lance> findByLeilao(Leilao leilao);

	ArrayList<Lance> findByValor(double valor);

	Lance getReferenceById(Long id);


}
