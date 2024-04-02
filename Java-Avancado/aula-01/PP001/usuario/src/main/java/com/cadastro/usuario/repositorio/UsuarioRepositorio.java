package com.cadastro.usuario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.usuario.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
