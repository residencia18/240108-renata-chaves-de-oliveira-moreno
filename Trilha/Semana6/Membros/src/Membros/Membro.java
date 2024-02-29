package Membros;

public class Membro {
    private String nome;
    private int numeroIdentificacao;

    public Membro(String nome, int numeroIdentificacao) {
        this.nome = nome;
        this.numeroIdentificacao = numeroIdentificacao;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Membro membro = (Membro) obj;
        return numeroIdentificacao == membro.numeroIdentificacao;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numeroIdentificacao);
    }
}
