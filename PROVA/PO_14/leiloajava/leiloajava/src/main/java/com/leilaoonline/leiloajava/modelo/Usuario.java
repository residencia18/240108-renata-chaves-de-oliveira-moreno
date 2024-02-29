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
	public List<Lance> getListaLances() {
		// TODO Auto-generated method stub
		return null;
	}
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCpf() {
		// TODO Auto-generated method stub
		return null;
	}

}
