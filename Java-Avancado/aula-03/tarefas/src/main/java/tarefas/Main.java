package tarefas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite o título da tarefa (ou 'sair' para encerrar): ");
            String titulo = scanner.nextLine();

            if (titulo.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("Digite a descrição da tarefa: ");
            String descricao = scanner.nextLine();

            Tarefas tarefa = new Tarefas(titulo, descricao);
            gerenciador.adicionarTarefa(tarefa);
            System.out.println("Tarefa adicionada com sucesso!");
        }

        System.out.println("Tarefas cadastradas:");
        gerenciador.listarTarefas();

        scanner.close();
    }
}
