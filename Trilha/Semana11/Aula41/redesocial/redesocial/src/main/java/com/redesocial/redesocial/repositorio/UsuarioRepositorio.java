package com.redesocial.redesocial.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redesocial.redesocial.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	List<Usuario> findByNome(String nome);


}
