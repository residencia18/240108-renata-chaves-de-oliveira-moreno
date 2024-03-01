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
    private String descricao;
    private BigDecimal precoInicial;
    private BigDecimal valorMinimo;
    private int status;
    
    // Default constructor
    public Leilao() {
    }
    
    // Constructor with parameters
    public Leilao(String descricao, BigDecimal precoInicial, BigDecimal valorMinimo) {
        this.descricao = descricao;
        this.precoInicial = precoInicial;
        this.valorMinimo = valorMinimo;
    }

    // Getters and setters
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

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public void addLance(Lance lance) {
        // TODO Auto-generated method stub
    }

    // Other methods if needed
}
