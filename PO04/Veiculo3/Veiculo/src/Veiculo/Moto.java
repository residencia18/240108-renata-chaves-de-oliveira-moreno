package Veiculo;

public class Moto extends Veiculo {
    public Moto(String modelo, String cor, int ano) {
        super(modelo, cor, ano);
    }

    @Override
    public void ligar() {
        System.out.println("Moto ligada");
    }

    // Adicione outros métodos específicos da Moto, se necessário
}
