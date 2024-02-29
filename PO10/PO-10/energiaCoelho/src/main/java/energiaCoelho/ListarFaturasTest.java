package energiaCoelho;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListarFaturasTest {

    private List<Fatura> faturas;
    
    @Before
    public void setUp() {
        // Inicializa a lista de faturas com algumas faturas para teste
        faturas = new ArrayList<>();
        faturas.add(new Fatura(0, 0, null/* valores das faturas para teste */));
        // Adicione mais faturas, se necessário, para testar diferentes cenários
    }

    @Test
    public List<Fatura> testListarFaturas() {
        // Configurar o cenário de teste (adicionar mais faturas, se necessário)
        int expectedSize = faturas.size();

        // Chamar o método a ser testado
        List<Fatura> resultado = testListarFaturas();

        // Verificar se o resultado é o esperado
        assertEquals(expectedSize, resultado.size());
        // Você também pode verificar outras propriedades das faturas, se necessário
		return resultado;
    }

	private void assertEquals(int expectedSize, int size) {
		// TODO Auto-generated method stub
		
	}
}
