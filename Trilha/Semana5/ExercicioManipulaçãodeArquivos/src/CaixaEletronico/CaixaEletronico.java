// CaixaEletronico.java
package CaixaEletronico;

public class CaixaEletronico {
    public static void sacar(int valor) throws ValorInvalidoException {
        if (valor % 10 != 0) {
            throw new ValorInvalidoException("Valor inválido: deve ser múltiplo de 10.");
        }

        // Lógica para realizar o saque...
        System.out.println("Saque de R$" + valor + " realizado com sucesso!");
    }
}
