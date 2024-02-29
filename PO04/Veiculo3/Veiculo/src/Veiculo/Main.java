package Veiculo;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo1 = new Carro("Fusca", "Azul", 2000);
        Veiculo veiculo2 = new Moto("CG 125", "Vermelha", 2022);

        veiculo1.ligar();
        veiculo1.acelerar();
        veiculo1.parar();

        System.out.println();

        veiculo2.ligar();
        veiculo2.acelerar();
        veiculo2.parar();
    }
}
