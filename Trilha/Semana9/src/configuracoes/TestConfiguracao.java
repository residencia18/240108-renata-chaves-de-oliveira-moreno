package configuracoes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestConfiguracao {

    @Test
    void testSetAlfabeto() throws Exception {
        // Teste 1: Configuração inicial correta
        Configuracao configuracao = new Configuracao();
        String senhaInicial = "ABCDEFGH";
        configuracao.setAlfabeto(senhaInicial);
        assertEquals(senhaInicial, configuracao.getAlfabeto());

        // Teste 2: Tentar definir um alfabeto com caracteres repetidos (deve lançar exceção)
        assertThrows(Exception.class, () -> configuracao.setAlfabeto("ABCD"));
        assertEquals(senhaInicial, configuracao.getAlfabeto());

        // Teste 3: Tentar definir um alfabeto com 2 caracteres iguais no começo (deve lançar exceção)
        assertThrows(Exception.class, () -> configuracao.setAlfabeto("AABCD"));
        assertEquals(senhaInicial, configuracao.getAlfabeto());

        // Teste 4: Tentar definir um alfabeto com 2 caracteres iguais no final (deve lançar exceção)
        assertThrows(Exception.class, () -> configuracao.setAlfabeto("ABCDD"));
        assertEquals(senhaInicial, configuracao.getAlfabeto());

        // Teste 5: Tentar definir um alfabeto com 1 caracter no começo e outro no fim (deve lançar exceção)
        assertThrows(Exception.class, () -> configuracao.setAlfabeto("AABCDE"));
        assertEquals(senhaInicial, configuracao.getAlfabeto());

        // Teste 6: Tentar definir um alfabeto com 1 caracter em posição intermediária e outro no fim (deve lançar exceção)
        assertThrows(Exception.class, () -> configuracao.setAlfabeto("ABCDEA"));
        assertEquals(senhaInicial, configuracao.getAlfabeto());

        // Teste 7: Tentar definir um alfabeto com 1 caracter no início e outro em posição intermediária (deve lançar exceção)
        assertThrows(Exception.class, () -> configuracao.setAlfabeto("AACDE"));
        assertEquals(senhaInicial, configuracao.getAlfabeto());

        // Teste 8: Tentar definir um alfabeto com 2 caracteres em posições intermediárias adjacentes (deve lançar exceção)
        assertThrows(Exception.class, () -> configuracao.setAlfabeto("ABCCDE"));
        assertEquals(senhaInicial, configuracao.getAlfabeto());

        // Teste 9: Tentar definir um alfabeto com 3 caracteres em posições intermediárias não adjacentes (deve lançar exceção)
        assertThrows(Exception.class, () -> configuracao.setAlfabeto("ABCDCE"));
        assertEquals(senhaInicial, configuracao.getAlfabeto());
    }
}
