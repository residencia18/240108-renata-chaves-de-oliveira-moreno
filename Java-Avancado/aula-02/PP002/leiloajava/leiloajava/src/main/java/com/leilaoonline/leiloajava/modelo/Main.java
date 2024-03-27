package com.leilaoonline.leiloajava.modelo;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leilaoonline.leiloajava.controller.form.LeilaoForm;

public class Main {
    public static void main(String[] args) throws Exception {
        
        LeilaoForm leilaoForm = new LeilaoForm();
        leilaoForm.setNome("Leilão de Teste");
        leilaoForm.setDescricao("Este é um leilão de teste");
        leilaoForm.setPrecoInicial(new BigDecimal("100.00"));

        
        ObjectMapper objectMapper = new ObjectMapper();

    
        String json = objectMapper.writeValueAsString(leilaoForm);


        System.out.println(json);
    }
}
