package poo7;

import java.util.List;
import java.util.Scanner;


public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler dados existentes do arquivo
        List<Estudante> estudantes = LerArquivo.lerEstudantesDoArquivo("estudantes.json");

        // Exibir menu
        int escolha;
        do {
            System.out.println("\n------ Menu ------");
            System.out.println("1. Visualizar Estudantes");
            System.out.println("2. Inserir Novo Estudante");
            System.out.println("3. Alterar Estudante");
            System.out.println("4. Excluir Estudante");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

            switch (escolha) {
                case 1:
                    // Visualizar Estudantes
                    exibirEstudantes(estudantes);
                    break;
                case 2:
                    // Inserir Novo Estudante
                    inserirNovoEstudante(estudantes, scanner);
                    break;
                case 3:
                    // Alterar Estudante
                    alterarEstudante(estudantes, scanner);
                    break;
                case 4:
                    // Excluir Estudante
                    excluirEstudante(estudantes, scanner);
                    break;
                case 0:
                    // Sair
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 0);

        // Gravar os dados atualizados no arquivo antes de encerrar
        GravarEstudantes.gravarEstudantesParaArquivo(estudantes, "estudantes.json");

        // Fechar o scanner no final do programa
        scanner.close();
    }

    // Métodos para exibir, inserir, alterar e excluir estudantes
    private static void exibirEstudantes(List<Estudante> estudantes) {
        System.out.println("\n------ Estudantes ------");
        for (Estudante estudante : estudantes) {
            System.out.println(estudante);
        }
    }

    private static void inserirNovoEstudante(List<Estudante> estudantes, Scanner scanner) {
        System.out.println("\nInserir novo estudante:");
        System.out.println("Digite o nome do estudante:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF do estudante:");
        String cpf = scanner.nextLine();

        System.out.println("Digite o CRA do estudante:");
        float cra = Float.parseFloat(scanner.nextLine());

        System.out.println("Digite o ano de admissão do estudante:");
        int anoDeAdmissao = Integer.parseInt(scanner.nextLine());

        Estudante novoEstudante = new Estudante(nome, cpf, cra, anoDeAdmissao);
        estudantes.add(novoEstudante);

        System.out.println("Novo estudante inserido com sucesso!");
    }

    private static void alterarEstudante(List<Estudante> estudantes, Scanner scanner) {
        System.out.println("\nAlterar dados de um estudante:");
        System.out.println("Digite o CPF do estudante a ser alterado:");
        String cpfAlvo = scanner.nextLine();

        Estudante estudanteAlvo = null;
        for (Estudante estudante : estudantes) {
            if (estudante.getCpf().equals(cpfAlvo)) {
                estudanteAlvo = estudante;
                break;
            }
        }

        if (estudanteAlvo != null) {
            System.out.println("Novo nome do estudante:");
            estudanteAlvo.setNome(scanner.nextLine());

            System.out.println("Novo CRA do estudante:");
            estudanteAlvo.setCra(Float.parseFloat(scanner.nextLine()));

            System.out.println("Novo ano de admissão do estudante:");
            estudanteAlvo.setAnoDeAdmissao(Integer.parseInt(scanner.nextLine()));

            System.out.println("Dados do estudante alterados com sucesso!");
        } else {
            System.out.println("Estudante não encontrado.");
        }
    }

    private static void excluirEstudante(List<Estudante> estudantes, Scanner scanner) {
        System.out.println("\nExcluir um estudante:");
        System.out.println("Digite o CPF do estudante a ser excluído:");
        String cpfAlvo = scanner.nextLine();

        Estudante estudanteAlvo = null;
        for (Estudante estudante : estudantes) {
            if (estudante.getCpf().equals(cpfAlvo)) {
                estudanteAlvo = estudante;
                break;
            }
        }

        if (estudanteAlvo != null) {
            System.out.println("Tem certeza de que deseja excluir o estudante? (Digite 'sim' para confirmar)");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("sim")) {
                estudantes.remove(estudanteAlvo);
                System.out.println("Estudante excluído com sucesso!");
            } else {
                System.out.println("Operação de exclusão cancelada.");
            }
        } else {
            System.out.println("Estudante não encontrado.");
        }
    }
}
