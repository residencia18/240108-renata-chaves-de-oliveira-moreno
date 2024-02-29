package Membros;

import java.util.HashSet;
import java.util.Set;

public class Comunidade {
    private Set<Membro> membros;

    public Comunidade() {
        this.membros = new HashSet<>();
    }

    public void adicionarMembro(Membro membro) {
        membros.add(membro);
    }

    public void exibirMembros() {
        for (Membro membro : membros) {
            System.out.println("Nome: " + membro.getNome() + ", Número de Identificação: " + membro.getNumeroIdentificacao());
        }
    }

    public void removerMembro(int numeroIdentificacao) {
        membros.removeIf(membro -> membro.getNumeroIdentificacao() == numeroIdentificacao);
    }
}
