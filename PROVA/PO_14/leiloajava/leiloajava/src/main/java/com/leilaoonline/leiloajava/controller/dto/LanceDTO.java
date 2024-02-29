package com.leilaoonline.leiloajava.controller.dto;

import java.math.BigDecimal;

import com.leilaoonline.leiloajava.modelo.Concorrente;
import com.leilaoonline.leiloajava.modelo.Lance;
import com.leilaoonline.leiloajava.modelo.Leilao;

public class LanceDTO {

    private Long Id;
    private BigDecimal Valor;
    private Leilao LeilaoDTO;
    private Concorrente ConcorrenteDTO;
	private Object Leilao;
	private Object Concorrente;

    public LanceDTO(Lance lance) {

        this.Id = lance.getId();
        this.Valor = lance.getValor();
        this.Leilao = lance.getLeilao();
        this.Concorrente = lance.getConcorrente();

    }

    public Long getId() {
        return Id;
    }

    public BigDecimal getValor() {
        return Valor;
    }

    public com.leilaoonline.leiloajava.modelo.Leilao getLeilao() {
        return (com.leilaoonline.leiloajava.modelo.Leilao) Leilao;
    }

    public com.leilaoonline.leiloajava.modelo.Concorrente getConcorrente() {
        return (com.leilaoonline.leiloajava.modelo.Concorrente) Concorrente;
    }
}