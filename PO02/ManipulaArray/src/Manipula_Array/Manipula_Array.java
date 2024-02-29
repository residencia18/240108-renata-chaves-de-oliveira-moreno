package Manipula_Array;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays; // Importando a classe Arrays para exibir arrays de forma mais fácil.

public class Manipula_Array {

    // Método para criar um array de números inteiros lidos do usuário.
    public static int[] criarArrayDoUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o tamanho do array: ");
        int tamanho = scanner.nextInt();

        int[] array = new int[tamanho];

        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    // Método para criar um array aleatório de números inteiros.
    public static int[] criarArrayAleatorio(int tamanho, int valorMaximo) {
        Random random = new Random();
        int[] array = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(valorMaximo + 1);
        }

        return array;
    }

    // Método para calcular a soma de todos os elementos no array.
    public static int calcularSoma(int[] array) {
        int soma = 0;

        for (int valor : array) {
            soma += valor;
        }

        return soma;
    }

    // Método para encontrar o maior valor no array.
    public static int encontrarMaiorValor(int[] array) {
        int maior = array[0];

        for (int valor : array) {
            if (valor > maior) {
                maior = valor;
            }
        }

        return maior;
    }

    // Método para encontrar o menor valor no array.
    public static int encontrarMenorValor(int[] array) {
        int menor = array[0];

        for (int valor : array) {
            if (valor < menor) {
                menor = valor;
            }
        }

        return menor;
    }

    // Função principal para testar as funcionalidades.
    public static void main(String[] args) {
        // Criar array do usuário e array aleatório.
        int[] arrayUsuario = criarArrayDoUsuario();
        int[] arrayAleatorio = criarArrayAleatorio(5, 100);

        // Exibir os arrays criados.
        System.out.println("Array do Usuário: " + Arrays.toString(arrayUsuario));
        System.out.println("Array Aleatório: " + Arrays.toString(arrayAleatorio));

        // Calcular e exibir a soma, o maior e o menor valor dos arrays.
        System.out.println("Soma do Array do Usuário: " + calcularSoma(arrayUsuario));
        System.out.println("Maior Valor do Array Aleatório: " + encontrarMaiorValor(arrayAleatorio));
        System.out.println("Menor Valor do Array do Usuário: " + encontrarMenorValor(arrayUsuario));
    }
}
