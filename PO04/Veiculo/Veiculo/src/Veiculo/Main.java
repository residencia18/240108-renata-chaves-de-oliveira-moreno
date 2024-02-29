package Veiculo;

public class Main {
    public static void main(String[] args) {
        Garagem garagemComTomada = new Garagem(true);
        Garagem garagemSemTomada = new Garagem(false);

        Carro carroEletrico = new Carro("Tesla Model S", "Preto", 2022, true);
        Moto motoComum = new Moto("Honda CB500", "Azul", 2021, false);

        carroEletrico.estacionar(garagemComTomada);
        motoComum.estacionar(garagemSemTomada);
    }
}
