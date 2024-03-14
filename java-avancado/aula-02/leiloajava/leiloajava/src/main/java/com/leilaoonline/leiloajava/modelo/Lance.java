package com.leilaoonline.leiloajava.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Lance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private BigDecimal valor;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Leilao leilao;
    
    public Lance() {
        // Construtor vazio necessário para o Hibernate
    }

    public Lance(BigDecimal valor, Usuario usuario, Leilao leilao) {
        this.valor = valor;
        this.usuario = usuario;
        this.leilao = leilao;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
