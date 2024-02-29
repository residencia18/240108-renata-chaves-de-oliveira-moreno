package CalculadoraMedia;

import java.util.ArrayList;

public class CalculadoraMedia {

    public static void main(String[] args) {
        // Criando um ArrayList para armazenar números inteiros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Adicionando números ao ArrayList
        adicionarNumeros(numeros, 10);
        adicionarNumeros(numeros, 20);
        adicionarNumeros(numeros, 30);

        // Calculando a soma e exibindo a média
        calcularEMostrarMedia(numeros);
    }

    // Método para adicionar números inteiros ao ArrayList
    public static void adicionarNumeros(ArrayList<Integer> lista, int numero) {
        lista.add(numero);
    }

    // Método para calcular a soma e exibir a média dos números no ArrayList
    public static void calcularEMostrarMedia(ArrayList<Integer> lista) {
        int soma = 0;

        // Calculando a soma
        for (int numero : lista) {
            soma += numero;
        }

        // Exibindo a média
        if (!lista.isEmpty()) {
            double media = (double) soma / lista.size();
            System.out.println("Soma: " + soma);
            System.out.println("Média: " + media);
        } else {
            System.out.println("A lista está vazia. Não é possível calcular a média.");
        }
    }
}
