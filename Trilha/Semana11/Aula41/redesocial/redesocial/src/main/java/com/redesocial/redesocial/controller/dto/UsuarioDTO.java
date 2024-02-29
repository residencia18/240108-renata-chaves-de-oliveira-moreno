package com.redesocial.redesocial.controller.dto;

import com.redesocial.redesocial.modelo.Usuario;

public class UsuarioDTO {
    
    private long id;
    private String nome, email;
    
    public UsuarioDTO(Usuario usuarios) {
        id = usuarios.getId();
        nome = usuarios.getNome();
        email = usuarios.getEmail();
    }
    
    
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
