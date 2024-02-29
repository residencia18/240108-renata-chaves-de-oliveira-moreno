package com.redesocial.redesocial.repositorio;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redesocial.redesocial.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	ArrayList<Usuario> findByNome(String nome);

	Usuario getReferenceById(Integer id);


}
