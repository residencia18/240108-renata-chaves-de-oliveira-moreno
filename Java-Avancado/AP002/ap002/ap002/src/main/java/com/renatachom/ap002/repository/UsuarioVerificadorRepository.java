package com.renatachom.ap002.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renatachom.ap002.entity.UsuarioVerificadorEntity;

public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long>{

	public Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);
}
