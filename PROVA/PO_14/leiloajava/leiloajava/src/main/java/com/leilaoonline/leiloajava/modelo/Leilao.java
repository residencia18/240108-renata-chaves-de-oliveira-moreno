package com.leilaoonline.leiloajava.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Leilao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal precoInicial;
    
    public Leilao(String nome, String descricao, BigDecimal precoInicial) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoInicial = precoInicial;
    }

	public void addLance(Lance lance) {
		// TODO Auto-generated method stub
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome2) {
	
		
	}
	
	

 }