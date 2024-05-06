package com.renatachom.ap002.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renatachom.ap002.dto.AuthenticationDTO;
import com.renatachom.ap002.dto.UsuarioDTO;
import com.renatachom.ap002.service.AuthService;
import com.renatachom.ap002.service.TokenService;
import com.renatachom.ap002.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private AuthService authService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto){
		
	return ResponseEntity.ok(authService.login(authDto));
	}
	
	
	@PostMapping(value = "/novoUsuario")
	public void inserirNovoUsuario(@RequestBody UsuarioDTO novoUsuario){
		usuarioService.inserirNovoUsuario(novoUsuario);
	}
	
	@GetMapping(value = "/verificarCadastro/{uuid}")
	public String verificarCadastro(@PathVariable("uuid") String uuid) {
		return usuarioService.verificarCadastro(uuid);
	}
	
}