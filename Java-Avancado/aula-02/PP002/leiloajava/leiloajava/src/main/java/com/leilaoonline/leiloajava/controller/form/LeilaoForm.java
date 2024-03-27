package com.leilaoonline.leiloajava.controller.form;

import java.math.BigDecimal;

public class LeilaoForm {
    private String nome;
    private String descricao;
    private BigDecimal precoInicial;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPrecoInicial() {
		return precoInicial;
	}
	public void setPrecoInicial(BigDecimal precoInicial) {
		this.precoInicial = precoInicial;
	}
    
    

}
