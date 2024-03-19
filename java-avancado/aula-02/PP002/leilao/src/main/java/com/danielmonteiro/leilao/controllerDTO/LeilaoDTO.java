package com.danielmonteiro.leilao.controllerDTO;

import com.danielmonteiro.leilao.modelo.Leilao;

public class LeilaoDTO {

	private Long id;
	private String descricao,status;
	private double valorMinimo;
	
	public LeilaoDTO(Leilao leilao) {

		this.id = leilao.getId();
		this.descricao = leilao.getDescricao();
		this.status = leilao.getStatus();
		this.valorMinimo = leilao.getValorMinimo();
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getStatus() {
		return status;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}
	
	
}
