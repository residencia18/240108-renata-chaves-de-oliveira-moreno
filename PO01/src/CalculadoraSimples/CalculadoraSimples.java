package CalculadoraSimples;

import java.util.Scanner;


public class CalculadoraSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar dois números float
        System.out.print("Digite o primeiro número: ");
        float numero1 = scanner.nextFloat();

        System.out.print("Digite o segundo número: ");
        float numero2 = scanner.nextFloat();

        // Exibir menu de operações
        System.out.println("Escolha uma operação:");
        System.out.println("A - Adição");
        System.out.println("S - Subtração");
        System.out.println("M - Multiplicação");
        System.out.println("D - Divisão");

        // Ler a escolha do usuário
        System.out.print("Digite a letra da operação desejada: ");
        char operacao = scanner.next().charAt(0);

        // Calcular e exibir o resultado
        float resultado = calcularOperacao(numero1, numero2, operacao);
        System.out.println("O resultado da operação é: " + resultado);

        scanner.close();
    }

    // Função para calcular a operação selecionada
    public static float calcularOperacao(float num1, float num2, char operacao) {
        switch (operacao) {
            case 'A':
            case 'a':
                return num1 + num2;
            case 'S':
            case 's':
                return num1 - num2;
            case 'M':
            case 'm':
                return num1 * num2;
            case 'D':
            case 'd':
                // Verificar se o divisor é diferente de zero
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Erro: divisão por zero.");
                    return 0;
                }
            default:
                System.out.println("Operação inválida.");
                return 0;
        }
    }
}
