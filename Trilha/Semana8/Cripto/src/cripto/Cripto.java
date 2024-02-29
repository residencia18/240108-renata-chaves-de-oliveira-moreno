package cripto;

import facede.Facede;

public class Cripto {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Informe dois nomes de arquivos e uma senha como parâmetros.");
            return;
        }

        String file1 = args[0];
        String file2 = args[1];
        String senha = args[2];

        // Exibindo a senha para depuração
        System.out.println("Senha fornecida: " + senha);

        // Invocando o método estático process da classe Facade
        Facede.process(file1, file2, senha);

        System.out.println("Processamento de arquivos concluído com sucesso!");
    }
}
