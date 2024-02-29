package conversordetemp;
import java.util.Scanner;

public class ConversorDeTemperatura {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temp, resultado;
        char unidadeOrigem;

        System.out.println("Digite a temperatura: ");
        temp = sc.nextDouble();

        System.out.println("Escolha a unidade de origem (C para Celsius, F para Fahrenheit): ");
        unidadeOrigem = sc.next().charAt(0);

        if (unidadeOrigem == 'C' || unidadeOrigem == 'c') {
            resultado = celsiusParaFahrenheit(temp);
            System.out.println("A temperatura em Fahrenheit: " + resultado + " ºF");
        }
        else if (unidadeOrigem == 'F' || unidadeOrigem == 'f') {
            resultado = fahrenheitParaCelsius(temp);
            System.out.println("A temperatura em Celsius: " + resultado + " ºC");
        }
        else {
            System.out.println("Unidade de origem inválida. Use 'C' ou 'F'.");
        }
    }

    private static double celsiusParaFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    private static double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
