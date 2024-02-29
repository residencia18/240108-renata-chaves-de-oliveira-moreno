package Membros;

public class Main {
    public static void main(String[] args) {
        Comunidade comunidade = new Comunidade();

        Membro membro1 = new Membro("João", 1);
        Membro membro2 = new Membro("Maria", 2);
        Membro membro3 = new Membro("José", 1); // Número de identificação duplicado

        comunidade.adicionarMembro(membro1);
        comunidade.adicionarMembro(membro2);
        comunidade.adicionarMembro(membro3);

        System.out.println("Membros da Comunidade:");
        comunidade.exibirMembros();

        comunidade.removerMembro(2);

        System.out.println("\nMembros da Comunidade após remover o membro com número de identificação 2:");
        comunidade.exibirMembros();
    }
}
