package cpf;

import com.github.javafaker.Faker;

public class CustomFaker extends Faker {
    
    public CustomFaker() {
        super();
    }
    
    // Método para gerar um CPF fictício
    public String cpf() {
        StringBuilder cpf = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            cpf.append(random().nextInt(10));
        }
        int sum = 0;
        int weight = 10;
        for (int i = 0; i < 9; i++) {
            sum += cpf.charAt(i) * weight;
            weight--;
        }
        int remainder = sum % 11;
        if (remainder < 2) {
            cpf.append("0");
        } else {
            cpf.append(11 - remainder);
        }
        sum = 0;
        weight = 11;
        for (int i = 0; i < 10; i++) {
            sum += cpf.charAt(i) * weight;
            weight--;
        }
        remainder = sum % 11;
        if (remainder < 2) {
            cpf.append("0");
        } else {
            cpf.append(11 - remainder);
        }
        return cpf.toString();
    }
}
