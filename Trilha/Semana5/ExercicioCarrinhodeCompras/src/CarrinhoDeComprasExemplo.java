package CarrinhoDeCompras;

public class Exemplo {
    public static void main(String[] args) {
        try {
            CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

            // Adiciona itens ao carrinho
            Item item1 = new Item(1, "Produto A", 29.99);
            carrinho.adicionarItem(item1, 2);

            Item item2 = new Item(2, "Produto B", 49.99);
            carrinho.adicionarItem(item2, 1);

            // Calcula o total da compra
            double totalCompra = carrinho.calcularTotalCompra();
            System.out.println("Total da compra: " + totalCompra);

            // Fecha a compra
            carrinho.fecharCompra();

            // Tenta adicionar um item após fechar a compra (deve gerar a exceção)
            carrinho.adicionarItem(item2, 1);

        } catch (CarrinhoFechadoException | CarrinhoVazioException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
