package com.redesocial.redesocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.redesocial.controller.dto.UsuarioDTO;
import com.redesocial.redesocial.modelo.Usuario;
import com.redesocial.redesocial.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping("/listausuarios")
	public List<UsuarioDTO> listaUsuarios(){
		List<Usuario> listaUSuarios = (ArrayList<Usuario>)usuarioRepository.findAll();
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		for (Usuario u: listaUSuarios) {
			UsuarioDTO ud = new UsuarioDTO(u);
			lista.add(ud);
		}
		return lista;
	} 

}
