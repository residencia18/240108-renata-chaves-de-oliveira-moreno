package com.leilaoonline.leiloajava.controller.dto;

import java.util.List;

import com.leilaoonline.leiloajava.modelo.Concorrente;
import com.leilaoonline.leiloajava.modelo.Lance;

public class ConcorrenteDTO {

    private Long Id;
    private String Nome;
    private String Cpf;
    private List<Lance> ListaLances;

    public ConcorrenteDTO(Concorrente concorrente) {

        this.Id = concorrente.getId();
        this.Nome = concorrente.getNome();
        this.Cpf = concorrente.getCpf();
        this.ListaLances = concorrente.getListaLances();

    }

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public List<Lance> getListaLances() {
        return ListaLances;
    }
}