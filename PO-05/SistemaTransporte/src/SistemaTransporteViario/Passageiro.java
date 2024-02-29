package SistemaTransporteViario;

public class Passageiro {
    private String nome;
    private String tipoCartao;

    public Passageiro(String nome, String tipoCartao) {
        this.nome = nome;
        this.tipoCartao = tipoCartao;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }
}
