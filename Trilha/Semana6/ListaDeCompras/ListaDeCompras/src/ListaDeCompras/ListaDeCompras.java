package ListaDeCompras;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Item {
    private String nome;
    private float preco;

    public Item(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }
}

public class ListaDeCompras {
    private List<Item> listaDeItens;

    public ListaDeCompras() {
        this.listaDeItens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        listaDeItens.add(item);
    }

    public void exibirItens() {
        System.out.println("Lista de Compras:");
        for (Item item : listaDeItens) {
            System.out.println("Nome: " + item.getNome() + ", Preço: " + item.getPreco());
        }
    }

    public void exibirItensPorFaixaDeValor(float limiteInferior, float limiteSuperior) {
        if (limiteInferior > limiteSuperior) {
            float temp = limiteInferior;
            limiteInferior = limiteSuperior;
            limiteSuperior = temp;
        }

        System.out.println("Itens na faixa de valor entre " + limiteInferior + " e " + limiteSuperior + ":");
        for (Item item : listaDeItens) {
            if (item.getPreco() >= limiteInferior && item.getPreco() <= limiteSuperior) {
                System.out.println("Nome: " + item.getNome() + ", Preço: " + item.getPreco());
            }
        }
    }

    public void excluirItemPorNome(String nome) {
        Iterator<Item> iterator = listaDeItens.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getNome().equals(nome)) {
                iterator.remove();
                System.out.println("Item removido: " + nome);
                return;
            }
        }
        System.out.println("Item não encontrado: " + nome);
    }

    public static void main(String[] args) {
        ListaDeCompras listaDeCompras = new ListaDeCompras();

        listaDeCompras.adicionarItem(new Item("Arroz", 10.0f));
        listaDeCompras.adicionarItem(new Item("Feijão", 5.0f));
        listaDeCompras.adicionarItem(new Item("Carne", 20.0f));
        listaDeCompras.adicionarItem(new Item("Leite", 3.5f));

        listaDeCompras.exibirItens();

        listaDeCompras.exibirItensPorFaixaDeValor(5.0f, 15.0f);

        listaDeCompras.excluirItemPorNome("Feijão");

        listaDeCompras.exibirItens();
    }
}
