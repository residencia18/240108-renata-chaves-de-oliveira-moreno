package CalculadoraDivisao;

import java.util.Scanner;


//Exceção personalizada para divisão por zero
class DivisionByZeroException extends Exception {
public DivisionByZeroException(String mensagem) {
   super(mensagem);
}
}

//Classe da Calculadora
class Calculadora {
// Método para adição
public int adicionar(int a, int b) {
   return a + b;
}

// Método para subtração
public int subtrair(int a, int b) {
   return a - b;
}

// Método para multiplicação
public int multiplicar(int a, int b) {
   return a * b;
}

// Método para divisão de inteiros
public int dividir(int numerador, int denominador) throws DivisionByZeroException {
   if (denominador == 0) {
       throw new DivisionByZeroException("Divisão por zero não permitida!");
   }
   return numerador / denominador;
}

// Método para divisão de floats
public float dividir(float numerador, float denominador) throws DivisionByZeroException {
   if (denominador == 0) {
       throw new DivisionByZeroException("Divisão por zero não permitida!");
   }
   return numerador / denominador;
}
}

public class CalculadoraDivisao {
  public static void main(String[] args) {
      Calculadora calculadora = new Calculadora();

      try {
          int resultadoInteiro = calculadora.dividir(10, 2);
          System.out.println("Resultado da divisão inteira: " + resultadoInteiro);

          float resultadoFloat = calculadora.dividir(10.0f, 0.0f); // Isso lançará a exceção
          System.out.println("Resultado da divisão de floats: " + resultadoFloat);
      } catch (DivisionByZeroException e) {
          System.out.println("Erro: " + e.getMessage());
      }
  }
}
