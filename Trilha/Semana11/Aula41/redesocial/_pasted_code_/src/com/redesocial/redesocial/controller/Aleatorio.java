package com.redesocial.redesocial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Aleatorio {
    
    @RequestMapping("/aleatorio")
    public int aleatorio() {
        // Gerando um número aleatório entre 0 e 100
        Random random = new Random();
        int numeroAleatorio = random.nextInt(101); // Gera um número aleatório entre 0 (inclusive) e 101 (exclusivo)
        return numeroAleatorio;
    }
}
