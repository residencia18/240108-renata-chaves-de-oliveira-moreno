package com.redesocial.redesocial.controller.form;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.redesocial.redesocial.controller.dto.UsuarioDTO;
import com.redesocial.redesocial.modelo.Usuario;
import com.redesocial.redesocial.repositorio.UsuarioRepositorio;

public class UsuarioForm {

	private String nome,email,senha;

	//construtores
	public UsuarioForm(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public UsuarioForm() {
	}

	//gets e sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public Usuario criaUsuario() {
		
		Usuario usuario = new Usuario();
		
		nome = usuario.getNome();
		email = usuario.getEmail();
		senha = usuario.getSenha();
		
		return usuario;
		
	}
	
	private Usuario toUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		return usuario;
	}
	@PostMapping
	public ResponseEntity<UsuarioDTO> inserir(@RequestBody UsuarioForm usuarioForm, UriComponentsBuilder uriBuilder) {
		
		Usuario usuario = usuarioForm.toUsuario();
		
		UsuarioRepositorio usuRepo = null;
		
	    usuRepo.save(usuario);
		
	    UsuarioDTO usuDTO = new UsuarioDTO(usuario);
		
	    uriBuilder.path("/usuarios/{id}");
		
		URI uri = uriBuilder.buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(usuDTO);
	}
	
	
	
}
