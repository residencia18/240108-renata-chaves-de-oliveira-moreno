package ManipulacaoVector;

import java.util.Vector;

public class ManipulacaoVector {

    public static void main(String[] args) {
        // Exemplo de uso dos métodos
        Vector<String> vetorDeStrings = new Vector<>();

        // Adicionando elementos
        adicionarElemento(vetorDeStrings, "Elemento1");
        adicionarElemento(vetorDeStrings, "Elemento2");
        adicionarElemento(vetorDeStrings, "Elemento3");
        adicionarElemento(vetorDeStrings, "Elemento4");
        adicionarElemento(vetorDeStrings, "Elemento5");
        adicionarElemento(vetorDeStrings, "Elemento6");
        adicionarElemento(vetorDeStrings, "Elemento7");

        // Exibindo o vetor
        System.out.println("Vetor após adição: " + vetorDeStrings);

        // Removendo um elemento
        removerElemento(vetorDeStrings, "Elemento2");

        // Exibindo o vetor após remoção
        System.out.println("Vetor após remoção: " + vetorDeStrings);
    }

    // Método para adicionar elemento ao Vector de strings
    public static void adicionarElemento(Vector<String> vetor, String elemento) {
        vetor.add(elemento);
    }

    // Método para remover elemento do Vector de strings
    public static void removerElemento(Vector<String> vetor, String elemento) {
        vetor.remove(elemento);
    }
}
