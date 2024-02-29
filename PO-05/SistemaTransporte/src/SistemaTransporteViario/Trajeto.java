package SistemaTransporteViario;

import java.util.List;

public class Trajeto {
    private List<Trecho> trechos;

    public Trajeto(List<Trecho> trechos) {
        this.trechos = trechos;
    }

    public List<Trecho> getTrechos() {
        return trechos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trajeto: ");

        for (Trecho trecho : trechos) {
            stringBuilder.append(trecho.getOrigem().getNome())
                    .append(" -> ")
                    .append(trecho.getDestino().getNome())
                    .append(", ");
        }

        // Remover a vírgula extra no final
        if (stringBuilder.length() > 0) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }

        return stringBuilder.toString();
    }
}
