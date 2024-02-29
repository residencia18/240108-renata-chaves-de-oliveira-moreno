package SensorTemperatura;

public class SensorTemperatura {
    private Double temperatura;

    public void registraTemperatura(double valor, String escala) {
        // Registra a temperatura com o valor fornecido e a escala
        // Você pode adicionar validações ou conversões adicionais aqui, se necessário
        this.temperatura = valor;
    }

    public Double obterTemperaturaCelsius() {
        // Converte a temperatura para Celsius, se estiver em outra escala
        if (this.temperatura == null) {
            return null;  // Retorna null se a temperatura ainda não foi registrada
        } else {
            return this.temperatura;
        }
        // Adicione mais conversões de escala, se necessário
    }

    public Double obterTemperaturaFahrenheit() {
        // Converte a temperatura para Fahrenheit, se estiver em outra escala
        if (this.temperatura == null) {
            return null;  // Retorna null se a temperatura ainda não foi registrada
        } else {
            return (this.temperatura * 9 / 5) + 32;
        }
        // Adicione mais conversões de escala, se necessário
    }

    // Exemplo de uso
    public static void main(String[] args) {
        SensorTemperatura sensor = new SensorTemperatura();
        sensor.registraTemperatura(25, "Celsius");

        Double temperaturaCelsius = sensor.obterTemperaturaCelsius();
        Double temperaturaFahrenheit = sensor.obterTemperaturaFahrenheit();

        System.out.println("Temperatura em Celsius: " + temperaturaCelsius + "°C");
        System.out.println("Temperatura em Fahrenheit: " + temperaturaFahrenheit + "°F");
    }
}
