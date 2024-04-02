package cpf;

public class Main {
    public static void main(String[] args) {
        CustomFaker customFaker = new CustomFaker();

        // Gerar um CPF fictício
        String cpf = customFaker.cpf();
        System.out.println("CPF Fictício: " + cpf);
    }
}
