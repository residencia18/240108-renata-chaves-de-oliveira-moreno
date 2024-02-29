package facede;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import cripto.CopiarArquivos;

public class Facede {

    public static void process(String file1, String file2, String senha) {
        try {
            if (senha == null || senha.isEmpty()) {
                // Se a senha não for fornecida, copiar os arquivos sem realizar operação XOR
                CopiarArquivos.process(file1, file2);
            } else {
                // Se a senha for fornecida, realizar operação XOR
                try (FileInputStream fis = new FileInputStream(file1);
                     FileOutputStream fos = new FileOutputStream(file2)) {

                    int data;
                    int senhaIndex = 0;

                    while ((data = fis.read()) != -1) {
                        // Realiza a operação XOR com o byte correspondente da senha
                        int byteSenha = senha.charAt(senhaIndex) & 0xFF;
                        int resultadoXOR = data ^ byteSenha;
                        fos.write(resultadoXOR);

                        // Move para o próximo byte da senha ou volta ao início se necessário
                        senhaIndex = (senhaIndex + 1) % senha.length();
                    }
                }
            }

            System.out.println("Processamento de arquivos concluído com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao processar arquivos: " + e.getMessage());
        }
    }
}
