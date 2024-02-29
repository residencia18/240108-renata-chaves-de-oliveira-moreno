package com.renatachom.empresaAerea.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Piloto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numBreve;
	private String nome;
	
	//construtores
	public Piloto(Long id, Long numBreve, String nome) {
		this.id = id;
		this.numBreve = numBreve;
		this.nome = nome;
	}

	public Piloto() {
	}

	//gets e sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumBreve() {
		return numBreve;
	}

	public void setNumBreve(Long numBreve) {
		this.numBreve = numBreve;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}