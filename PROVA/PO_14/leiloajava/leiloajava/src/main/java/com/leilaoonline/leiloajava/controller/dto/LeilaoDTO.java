package com.leilaoonline.leiloajava.controller.dto;

public class LeilaoDTO {
    private Long id;
    private String nome;
    private String descricao;

    // Construtor
    public LeilaoDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

}
