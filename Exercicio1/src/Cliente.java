import java.util.Scanner;

public class Cliente {
    private String nome;
    private int idade;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o cpf: ");
            String cpf = scanner.nextLine();

            Cliente cliente = new Cliente(nome, cpf);

            System.out.println("\nDados do Cliente:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Idade: " + cliente.getIdade());

            System.out.print("\nDigite a nova idade: ");
            int novaIdade = scanner.nextInt();
            cliente.setIdade(novaIdade);

            System.out.println("\nDados do Cliente (após alteração):");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Idade: " + cliente.getIdade());
        } catch (Exception e) {
            System.out.println("Erro na entrada de dados: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

