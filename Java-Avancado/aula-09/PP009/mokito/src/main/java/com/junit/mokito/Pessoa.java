package com.junit.mokito;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {
    private String nome;
    private int idade;
    private char genero;

    public void imprimirInformacoes() {
        log.info("Nome: " + nome);
        log.info("Idade: " + idade);
        log.info("Gênero: " + genero);
    }
}
