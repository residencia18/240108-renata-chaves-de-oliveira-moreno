package com.leilaoonline.leiloajava.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Concorrente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    @OneToMany
    List<Lance> listaLances;

    public Concorrente() {
    }

    public Concorrente(Long id, String nome, String cpf, List<Lance> listaLances) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.listaLances = listaLances;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Lance> getListaLances() {
        return listaLances;
    }

    public void setListaLances(List<Lance> listaLances) {
        this.listaLances = listaLances;
    }
}