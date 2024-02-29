package Veiculo;

public class Carro extends Veiculo {
    public Carro(String modelo, String cor, int ano) {
        super(modelo, cor, ano);
    }

    @Override
    public void ligar() {
        System.out.println("Carro ligado");
    }

    // Adicione outros métodos específicos do Carro, se necessário
}
