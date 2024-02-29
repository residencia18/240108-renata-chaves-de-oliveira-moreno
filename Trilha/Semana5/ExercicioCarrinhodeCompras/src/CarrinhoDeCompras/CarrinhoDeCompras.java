package CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens;
    private boolean compraFechada;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
        this.compraFechada = false;
    }

    public void adicionarItem(Item item, int quantidade) throws CarrinhoFechadoException {
        validarCompraAberta();

        // Atualiza a quantidade do item se já estiver no carrinho
        if (itens.contains(item)) {
            Item itemExistente = itens.get(itens.indexOf(item));
            itemExistente.setQuantidade(itemExistente.getQuantidade() + quantidade);
        } else {
            item.setQuantidade(quantidade);
            itens.add(item);
        }
    }

    public void removerItem(Item item, int quantidade) throws CarrinhoFechadoException {
        validarCompraAberta();

        // Atualiza a quantidade do item ou remove se a quantidade for zero
        if (itens.contains(item)) {
            Item itemExistente = itens.get(itens.indexOf(item));
            itemExistente.setQuantidade(Math.max(0, itemExistente.getQuantidade() - quantidade));
            if (itemExistente.getQuantidade() == 0) {
                itens.remove(itemExistente);
            }
        }
    }

    public double calcularTotalCompra() throws CarrinhoVazioException {
        if (itens.isEmpty()) {
            throw new CarrinhoVazioException("Carrinho de compras vazio.");
        }

        double total = 0;
        for (Item item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void fecharCompra() {
        this.compraFechada = true;
    }

    private void validarCompraAberta() throws CarrinhoFechadoException {
        if (compraFechada) {
            throw new CarrinhoFechadoException("A compra já foi fechada. Não é possível adicionar ou remover itens.");
        }
    }
}

