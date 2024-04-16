package com.rechom.avancadojava.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.rechom.avancadojava.entity.Funcionario;
import com.rechom.avancadojava.repository.FuncionarioRepository;
import com.rechom.avancadojava.service.FuncionarioService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTest {

    @Mock
    private FuncionarioRepository repository;

    @InjectMocks
    private FuncionarioService service;

    @Test
    public void testFindAllFuncionarios() {
        Funcionario funcionario1 = new Funcionario("João", "Desenvolvedor");
        Funcionario funcionario2 = new Funcionario("Maria", "Gerente");
        List<Funcionario> funcionarios = Arrays.asList(funcionario1, funcionario2);

        when(repository.findAll()).thenReturn(funcionarios);

        List<Funcionario> result = service.findAllFuncionarios();

        assertEquals(2, result.size());
        assertEquals("João", result.get(0).getNome());
        assertEquals("Maria", result.get(1).getNome());
    }

    // Outros testes para os métodos do serviço podem ser adicionados aqui
}
