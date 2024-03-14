package com.leilaoonline.leiloajava.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leilaoonline.leiloajava.modelo.Lance;
import com.leilaoonline.leiloajava.modelo.Usuario;

public interface LanceRepositorio extends JpaRepository<Lance, Long> {
    List<Lance> findByUsuario(Usuario usuario);
}
