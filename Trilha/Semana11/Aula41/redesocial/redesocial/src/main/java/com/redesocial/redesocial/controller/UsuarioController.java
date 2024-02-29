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
@RequestMapping("/usuarios")

public class UsuarioController {

    
  
     @GetMapping
     public ArrayList<UsuarioDTO> listar(String name){
		System.out.println(name);
		return null;
    	 
    	
     }
    
}


