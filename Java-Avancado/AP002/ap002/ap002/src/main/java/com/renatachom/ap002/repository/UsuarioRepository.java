package com.renatachom.ap002.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatachom.ap002.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

	Optional<UsuarioEntity> findByLogin(String login);
}