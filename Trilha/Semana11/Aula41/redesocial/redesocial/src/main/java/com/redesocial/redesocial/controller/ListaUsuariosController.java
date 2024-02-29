package com.redesocial.redesocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.redesocial.controller.dto.UsuarioDTO;
import com.redesocial.redesocial.modelo.Usuario;
import com.redesocial.redesocial.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/listausuarios/")
public class ListaUsuariosController {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
        
	@GetMapping
     public List<UsuarioDTO> listaUsuarios(String name){
    	
    	 List<Usuario> listaUsuarios;
    	 if (name!=null)
    		 listaUsuarios = (ArrayList<Usuario>) usuarioRepositorio.findByNome(name);
    	
    	 else
    		listaUsuarios = (ArrayList<Usuario>) usuarioRepositorio.findAll();
    	    List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
    	 for (Usuario u: listaUsuarios) {
    		 UsuarioDTO ud = new UsuarioDTO(u);
    		 lista.add(ud);
    	 }
		return lista;
     }
    
}