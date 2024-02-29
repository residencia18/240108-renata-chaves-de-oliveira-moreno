package com.leilaoonline.leiloajava.controller.dto;

import java.util.List;

import com.leilaoonline.leiloajava.modelo.Concorrente;
import com.leilaoonline.leiloajava.modelo.Lance;
import com.leilaoonline.leiloajava.modelo.Usuario;

public class ConcorrenteDTO {

    private Long Id;
    private String Nome;
    private String Cpf;
    private List<Lance> ListaLances;

    public ConcorrenteDTO(Usuario usuario) {

        this.Id = usuario.getId();
        this.Nome = usuario.getNome();
        this.Cpf = usuario.getCpf();
        this.ListaLances = usuario.getListaLances();

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