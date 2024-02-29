package SistemaTransporteViario;

public class Motorista {
    private String nome;
    private String numeroCNH;

    public Motorista(String nome, String numeroCNH) {
        this.nome = nome;
        this.numeroCNH = numeroCNH;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }
}
