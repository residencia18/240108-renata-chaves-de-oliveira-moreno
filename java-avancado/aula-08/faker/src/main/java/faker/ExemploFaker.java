package faker;

import com.github.javafaker.Faker;

public class ExemploFaker {
    public static void main(String[] args) {
        Faker faker = new Faker();

        // Exemplo de uso do Faker
        String nome = faker.name().fullName();
        String endereco = faker.address().fullAddress();
        String empresa = faker.company().name();

        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Empresa: " + empresa);
    }
}
