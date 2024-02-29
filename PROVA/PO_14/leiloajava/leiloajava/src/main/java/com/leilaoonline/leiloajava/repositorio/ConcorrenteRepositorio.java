package com.leilaoonline.leiloajava.repositorio;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leilaoonline.leiloajava.modelo.Concorrente;

public interface ConcorrenteRepositorio extends JpaRepository<Concorrente, Integer> {

	List<Concorrente> findByNome(String nome);

	Optional<Concorrente> findById(Long id);

}