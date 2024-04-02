package com.cadastro.usuario.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.usuario.model.Usuario;
import com.cadastro.usuario.repositorio.UsuarioRepositorio;


@Service
public class UsuarioService {

	@Autowired
    private UsuarioRepositorio usoRepo;

    // Criando novo usuario
    public Usuario criarUsuario(Usuario usuario) {
        return usoRepo.save(usuario);
    }

    // lista todos usuarios
    public List<Usuario> listaUsuarios() {
        return usoRepo.findAll();
    }

    // busca por ID
    public Optional<Usuario> usuarioById(Long id) {
        return usoRepo.findById(id);
    }

    // Atualiza usuario
    public Usuario updateUsuario(Long id, Usuario usuario) {
        Optional<Usuario> user = usoRepo.findById(id);
        if (user.isPresent()) {
            Usuario usuExistente = user.get();
            usuExistente.setNome(usuario.getNome());
            usuExistente.setEmail(usuario.getEmail());
            return usoRepo.save(usuExistente);
        }
        return usuario;
    }

    // Deleta todos usuarios
    public void deletaUsuarios() {
    	usoRepo.deleteAll();
    }

    // Deleta um usuario
    public void deleteUsuario(Long id) {
    	usoRepo.deleteById(id);
    }

	public Usuario atualizaUsuario(Long id, Usuario usuario) {
		return null;
	}

	public void deletaUsuario(Long id) {
	}

	
}
