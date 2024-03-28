package com.junit.mokito;


import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

   
    private static final Logger log = Logger.getLogger(PessoaTest.class.getName());

    @Test
    public void testPessoa() {
        
        Pessoa pessoa = new Pessoa("João", 25, 'M');

      
        assertEquals("João", pessoa.getNome());
        assertEquals(25, pessoa.getIdade());
        assertEquals('M', pessoa.getGenero());
        
        
        log.info("Teste de Pessoa executado com sucesso!");
    }
}
