package LinkedListExemplo;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListExamplo {

    public static void main(String[] args) {
        // Crie uma LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // Insira elementos na LinkedList
        insertElements(linkedList, "Elemento1");
        insertElements(linkedList, "Elemento2");
        insertElements(linkedList, "Elemento3");
        insertElements(linkedList, "Elemento4");
        insertElements(linkedList, "Elemento5");
        insertElements(linkedList, "Elemento6");

        // Exiba os elementos na ordem original
        System.out.println("Elementos na ordem original:");
        displayElements(linkedList);

        // Exiba os elementos na ordem inversa
        System.out.println("\nElementos na ordem inversa:");
        displayElementsInReverseOrder(linkedList);
    }

    // Método para inserir elementos na LinkedList
    private static void insertElements(LinkedList<String> linkedList, String element) {
        linkedList.add(element);
    }

    // Método para exibir os elementos na ordem original
    private static void displayElements(LinkedList<String> linkedList) {
        for (String element : linkedList) {
            System.out.println(element);
        }
    }

    // Método para exibir os elementos na ordem inversa usando Iterator
    private static void displayElementsInReverseOrder(LinkedList<String> linkedList) {
        ListIterator<String> iterator = linkedList.listIterator(linkedList.size());

        while (iterator.hasPrevious()) {
            String element = iterator.previous();
            System.out.println(element);
        }
    }
}




    
