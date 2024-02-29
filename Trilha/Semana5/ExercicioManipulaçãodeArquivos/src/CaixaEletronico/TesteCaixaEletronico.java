// TesteCaixaEletronico.java
package CaixaEletronico;

import java.util.Scanner;

public class TesteCaixaEletronico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o valor do saque: ");
            int valorSaque = scanner.nextInt();

            // Tente sacar o valor inserido pelo usuário
            CaixaEletronico.sacar(valorSaque);
        } catch (ValorInvalidoException | ValorInvalidoRuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
