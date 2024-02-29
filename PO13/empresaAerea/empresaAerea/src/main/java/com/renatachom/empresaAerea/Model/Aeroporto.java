package com.renatachom.empresaAerea.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aeroporto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ICAO,nome;
	
	//Construtores
	public Aeroporto(Long id, String iCAO, String nome) {
		this.id = id;
		ICAO = iCAO;
		this.nome = nome;
	}

	//gets e sets
	public Aeroporto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getICAO() {
		return ICAO;
	}

	public void setICAO(String iCAO) {
		ICAO = iCAO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}