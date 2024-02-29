package com.redesocial.redesocial.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Aleatorio {

    @CrossOrigin
    @GetMapping("/aleatorio")
    public int aleatorio() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(101); 
        System.out.println("Número aleatório gerado: " + numeroAleatorio);
        return numeroAleatorio;
    }
}
