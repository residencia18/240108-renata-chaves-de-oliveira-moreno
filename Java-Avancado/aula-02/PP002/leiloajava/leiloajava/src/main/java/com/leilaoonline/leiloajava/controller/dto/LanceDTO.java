package com.leilaoonline.leiloajava.controller.dto;

import java.math.BigDecimal;

import com.leilaoonline.leiloajava.modelo.Lance;

public class LanceDTO {

    private Long id;
    private BigDecimal valor;
    private LeilaoDTO leilao;
    private ConcorrenteDTO concorrente;

    public LanceDTO(Lance lance) {
        this.id = lance.getId();
        this.valor = lance.getValor();
        this.leilao = new LeilaoDTO(lance.getLeilao());
        
        this.concorrente = new ConcorrenteDTO(lance.getUsuario());
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LeilaoDTO getLeilao() {
        return leilao;
    }

    public ConcorrenteDTO getConcorrente() {
        return concorrente;
    }
}
