package exemploaula;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JavaAvancado {
    private static final Logger logger = LogManager.getLogger(JavaAvancado.class);

    public static void main(String[] args) {
        logger.info("Iniciando o Projeto Java Avançado...");

        // Usando Lombok para criar um objeto com menos código
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria");
        pessoa.setIdade(25);

        // Logando os detalhes da pessoa
        logger.info("Detalhes da pessoa: {}", pessoa);

        // Realizando a validação dos atributos da pessoa
        validarPessoa(pessoa);

        logger.info("Finalizando o Projeto Java Avançado...");
    }

    private static void validarPessoa(Pessoa pessoa) {
        logger.info("Validando os atributos da pessoa...");

        // Validando os atributos usando as anotações do Bean Validation
        // A implementação da validação real pode ser feita em uma classe separada ou serviço
        if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
            logger.error("Nome da pessoa não pode ser nulo ou vazio.");
        }
        if (pessoa.getIdade() == null || pessoa.getIdade() < 0) {
            logger.error("Idade da pessoa não pode ser nula ou negativa.");
        } else if (pessoa.getIdade() < 18) {
            logger.warn("A pessoa é menor de idade.");
        }

        logger.info("Validação concluída.");
    }

    @Data
    static class Pessoa {
        @NotNull
        @Size(min = 2, max = 50)
        private String nome;

        @NotNull
        private Integer idade;
    }
}
