package com.leilaoonline.leiloajava.controller.dto;

import com.leilaoonline.leiloajava.modelo.Leilao;

public class LeilaoDTO {
    private Long id;
    private String descricao;

    // Construtor
    public LeilaoDTO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // Construtor para converter Leilao em LeilaoDTO
    public LeilaoDTO(Leilao leilao) {
        this.id = leilao.getId();
        this.descricao = leilao.getDescricao();
    }

    // Getters e setters
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
}
