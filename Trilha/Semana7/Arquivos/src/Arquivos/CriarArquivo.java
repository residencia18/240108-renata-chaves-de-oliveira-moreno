package Arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CriarArquivo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo: ");
        String nomeArquivo = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            System.out.println("Digite linhas de texto (digite uma linha vazia para encerrar):");

            while (true) {
                String linha = scanner.nextLine();

                if (linha.isEmpty()) {
                    System.out.println("Programa encerrado.");
                    break;
                }

                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao criar ou escrever no arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}
