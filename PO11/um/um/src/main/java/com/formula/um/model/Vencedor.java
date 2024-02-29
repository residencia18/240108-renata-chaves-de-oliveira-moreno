package com.formula.um.model;

public class Vencedor {
    private String nome;
    private String pais;
    private int numeroVitorias;

    public Vencedor(String nome, String pais, int numeroVitorias) {
        this.nome = nome;
        this.pais = pais;
        this.numeroVitorias = numeroVitorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNumeroVitorias() {
        return numeroVitorias;
    }

    public void setNumeroVitorias(int numeroVitorias) {
        this.numeroVitorias = numeroVitorias;
    }
}
