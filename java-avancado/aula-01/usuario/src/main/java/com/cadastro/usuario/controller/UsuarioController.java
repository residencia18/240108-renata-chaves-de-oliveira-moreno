package com.cadastro.usuario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.usuario.model.Usuario;
import com.cadastro.usuario.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	    @Autowired
	    private UsuarioService usuarioService;

	    // Cria novo usuario
	    @PostMapping
	    public Usuario criarUsuario(@RequestBody Usuario user) {
	        return usuarioService.criarUsuario(user);
	    }

	    // Lista todos usuarios
	    @GetMapping
	    public List<Usuario> listaUsuarios() {
	        return usuarioService.listaUsuarios();
	    }

	    // Busca pelo ID
	    @GetMapping("/{id}")
	    public Optional<Usuario> usuarioById(@PathVariable Long id) {
	        return usuarioService.usuarioById(id);
	    }

	    // Atualiza usuario pelo ID
	    @PutMapping("/{id}")
	    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
	        return usuarioService.updateUsuario(id, usuario);
	    }

	    // Deleta todos usuarios
	    @DeleteMapping
	    public String deletaUsuarios() {
	    	usuarioService.deletaUsuarios();
	        return "Usuarios excluidos com sucesso!";
	    }

	    // Deleta usuario pelo ID
	    @DeleteMapping("/{id}")
	    public void deleteUsuario(@PathVariable Long id) {
	    	usuarioService.deleteUsuario(id);
	    }
	}
	

