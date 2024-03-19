package com.danielmonteiro.leilao.controllerDTO;

import com.danielmonteiro.leilao.modelo.Lance;
import com.danielmonteiro.leilao.modelo.Leilao;

public class LanceDTO {

	private Long id;
	private Leilao leilao;
	private double valor;
	
	public LanceDTO(Lance lance) {
		this.id = lance.getId();
		this.leilao = lance.getLeilao();
		this.valor = lance.getValor();
	}

	public Long getId() {
		return id;
	}

	public Leilao getLeilao() {
		return leilao;
	}

	public double getValor() {
		return valor;
	}
	
	
	
}
