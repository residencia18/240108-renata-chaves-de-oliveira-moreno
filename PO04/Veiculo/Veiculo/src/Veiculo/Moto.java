package Veiculo;

public class Moto extends Veiculo {
    public Moto(String modelo, String cor, int ano, boolean eletrico) {
        super(modelo, cor, ano, eletrico);
    }

    @Override
    public void ligar() {
        System.out.println("Moto ligada");
    }
}
