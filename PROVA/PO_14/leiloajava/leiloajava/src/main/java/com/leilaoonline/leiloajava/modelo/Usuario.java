package com.leilaoonline.leiloajava.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    // Métodos getters e setters para os atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    // Método para retornar a lista de lances associada ao usuário
    public List<Lance> getListaLances() {
        // Implemente este método para retornar a lista de lances associada ao usuário
        return null;
    }

    // Método para retornar o CPF do usuário (caso esteja disponível)
    public String getCpf() {
        // Implemente este método para retornar o CPF do usuário, se estiver disponível
        return null;
    }
}

