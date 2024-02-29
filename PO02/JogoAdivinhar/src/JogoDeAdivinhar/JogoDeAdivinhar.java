package JogoDeAdivinhar;

import java.util.Random;
import java.util.Scanner;

public class JogoDeAdivinhar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroAleatorio = random.nextInt(100) + 1;
        int tentativa;
        int contadorTentativas = 0;

        System.out.println("Bem-vindo ao Jogo de Adivinhação!");
        System.out.println("Tente adivinhar o número entre 1 e 100.");

        do {
            System.out.print("Digite sua tentativa: ");
            tentativa = scanner.nextInt();
            contadorTentativas++;

            if (tentativa > numeroAleatorio) {
                System.out.println("Muito alto. Tente novamente.");
            } else if (tentativa < numeroAleatorio) {
                System.out.println("Muito baixo. Tente novamente.");
            } else {
                System.out.println("Parabéns! Você acertou em " + contadorTentativas + " tentativas.");
            }

        } while (tentativa != numeroAleatorio);

        scanner.close();
    }
}
