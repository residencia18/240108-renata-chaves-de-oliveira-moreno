package com.redesocial.redesocial.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.redesocial.controller.dto.UsuarioDTO;
import com.redesocial.redesocial.modelo.Usuario;
import com.redesocial.redesocial.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/usuarios/")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
     
    @PostMapping
     public List<UsuarioDTO> listaUsuarios(String nome){
	
    	List<Usuario> usuarios;
    	
    	if(nome != null) {
    		 usuarios = (ArrayList<Usuario>) usuarioRepositorio.findByNome(nome);
    	}
    	else {
    		usuarios = (ArrayList<Usuario>) usuarioRepositorio.findAll();
    	}
    	
    	 List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
    	 for(Usuario usu: usuarios) {
    		 UsuarioDTO usuDTO = new UsuarioDTO(usu);
    		 lista.add(usuDTO);
    		
    	 }
    	 
    	 return lista;
     }
  
    /*
    @GetMapping("/{id}")
    public UsuarioDTO listaUsuarios(@PathVariable Integer id) {
		
    	Usuario usuario;
    	    	
    	usuario = usuarioRepositorio.getReferenceById(id);
    	
    	UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
    	
    	return usuarioDTO;
   }
  */  
    
    @GetMapping("/{id}")
	public ResponseEntity<?> listaDeUsuarios(@PathVariable Integer id){
		
		try {
			Usuario usuario = usuarioRepositorio.getReferenceById(id);
			UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
			return ResponseEntity.ok(usuarioDTO);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
		
}
    
}
