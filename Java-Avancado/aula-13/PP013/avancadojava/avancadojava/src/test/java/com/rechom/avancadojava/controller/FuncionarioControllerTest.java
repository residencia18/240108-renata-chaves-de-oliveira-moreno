package com.rechom.avancadojava.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rechom.avancadojava.entity.Funcionario;
import com.rechom.avancadojava.service.FuncionarioService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(FuncionarioController.class)
@ExtendWith(MockitoExtension.class)
public class FuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private FuncionarioService service;

    @Test
    public void testCreateFuncionario() throws Exception {
        Funcionario funcionario = new Funcionario("Renata", "Desenvolvedora");
        when(service.createFuncionario(funcionario)).thenReturn(funcionario);

        mockMvc.perform(post("/funcionarios")
                .contentType("application/json")
                .content(new ObjectMapper().writeValueAsString(funcionario)))
                .andExpect(status().isCreated());
    }
}
