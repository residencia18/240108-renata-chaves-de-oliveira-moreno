package Veiculo;

public class Carro extends Veiculo {
    public Carro(String modelo, String cor, int ano, boolean eletrico) {
        super(modelo, cor, ano, eletrico);
    }

    @Override
    public void ligar() {
        System.out.println("Carro ligado");
    }
}
