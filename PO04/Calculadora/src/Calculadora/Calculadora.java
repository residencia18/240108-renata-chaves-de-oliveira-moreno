package Calculadora;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora {

    private Scanner scanner;

    public Calculadora() {
        this.scanner = new Scanner(System.in);
    }

    // Métodos para operações básicas com inteiros
    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Não é possível dividir por zero.");
            return 0;
        }
    }

    // Métodos para operações básicas com floats
    public float somar(float a, float b) {
        return a + b;
    }

    public float subtrair(float a, float b) {
        return a - b;
    }

    public float multiplicar(float a, float b) {
        return a * b;
    }

    public float dividir(float a, float b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Não é possível dividir por zero.");
            return 0;
        }
    }

    // Métodos para operações com ArrayLists
    public int somar(ArrayList<Integer> numeros) {
        int resultado = 0;
        for (int numero : numeros) {
            resultado += numero;
        }
        return resultado;
    }

    public float multiplicar(ArrayList<Float> numeros) {
        float resultado = 1;
        for (float numero : numeros) {
            resultado *= numero;
        }
        return resultado;
    }

    // Método para obter entrada do usuário
    private int obterNumeroInteiro(String mensagem) {
        System.out.print(mensagem + ": ");
        return scanner.nextInt();
    }

    // Método para obter entrada do usuário
    private float obterNumeroFloat(String mensagem) {
        System.out.print(mensagem + ": ");
        return scanner.nextFloat();
    }

    // Exemplos de uso no método main
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        // Exemplos de operações básicas com inteiros
        int a = calculadora.obterNumeroInteiro("Digite o primeiro número inteiro");
        int b = calculadora.obterNumeroInteiro("Digite o segundo número inteiro");
        System.out.println("Soma: " + calculadora.somar(a, b));
        System.out.println("Subtração: " + calculadora.subtrair(a, b));
        System.out.println("Multiplicação: " + calculadora.multiplicar(a, b));
        System.out.println("Divisão: " + calculadora.dividir(a, b));

        // Exemplos de operações básicas com floats
        float c = calculadora.obterNumeroFloat("Digite o primeiro número float");
        float d = calculadora.obterNumeroFloat("Digite o segundo número float");
        System.out.println("Soma: " + calculadora.somar(c, d));
        System.out.println("Subtração: " + calculadora.subtrair(c, d));
        System.out.println("Multiplicação: " + calculadora.multiplicar(c, d));
        System.out.println("Divisão: " + calculadora.dividir(c, d));

        // Exemplos de operações com ArrayLists
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(calculadora.obterNumeroInteiro("Digite um número inteiro"));
        intList.add(calculadora.obterNumeroInteiro("Digite outro número inteiro"));
        intList.add(calculadora.obterNumeroInteiro("Digite mais um número inteiro"));
        System.out.println("Soma da lista de inteiros: " + calculadora.somar(intList));

        ArrayList<Float> floatList = new ArrayList<>();
        floatList.add(calculadora.obterNumeroFloat("Digite um número float"));
        floatList.add(calculadora.obterNumeroFloat("Digite outro número float"));
        floatList.add(calculadora.obterNumeroFloat("Digite mais um número float"));
        System.out.println("Multiplicação da lista de floats: " + calculadora.multiplicar(floatList));
    }
}

