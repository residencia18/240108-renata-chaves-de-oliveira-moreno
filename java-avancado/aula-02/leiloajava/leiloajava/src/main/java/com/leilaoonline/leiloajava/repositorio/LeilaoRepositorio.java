package com.leilaoonline.leiloajava.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leilaoonline.leiloajava.modelo.Leilao;

@Repository
public interface LeilaoRepositorio extends JpaRepository<Leilao, Long> {

}


