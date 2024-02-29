package Veiculo;

import java.util.ArrayList;
import java.util.List;

public class Garagem {
    private List<Veiculo> veiculos;
    private boolean tomadaEletrica;

    public Garagem(boolean tomadaEletrica) {
        this.veiculos = new ArrayList<>();
        this.tomadaEletrica = tomadaEletrica;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public boolean temTomadaEletrica() {
        return tomadaEletrica;
    }
}
