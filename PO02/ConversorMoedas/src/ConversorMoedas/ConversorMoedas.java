package ConversorMoedas;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Scanner;



public class ConversorMoedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar ao usuário a taxa de câmbio
        System.out.print("Insira a taxa de câmbio: ");
        double taxaCambio = scanner.nextDouble();

        // Solicitar ao usuário a quantidade em dólares
        System.out.print("Insira a quantidade em dólares: ");
        double quantidadeDolares = scanner.nextDouble();

        // Calcular o valor convertido
        double valorConvertido = converterMoeda(quantidadeDolares, taxaCambio);

        // Exibir o resultado
        System.out.println("O valor convertido é: " + valorConvertido);
    }

    // Método para converter a quantidade em dólares para outra moeda
    private static double converterMoeda(double quantidadeDolares, double taxaCambio) {
        return quantidadeDolares * taxaCambio;
    }
}


