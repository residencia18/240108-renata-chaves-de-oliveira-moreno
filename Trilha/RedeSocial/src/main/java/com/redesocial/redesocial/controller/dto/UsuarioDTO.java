package com.redesocial.redesocial.controller.dto;

import com.redesocial.redesocial.modelo.Usuario;

public class UsuarioDTO {
    
    private Integer id;
    private String nome, email;
    
    public UsuarioDTO(Usuario usuarios) {
        id = usuarios.getId();
        nome = usuarios.getNome();
        email = usuarios.getEmail();
    }
    
    
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
