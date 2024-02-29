package Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ItemPedido {
    private String produto;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(String produto, int quantidade, double precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double calcularSubtotal() {
        return quantidade * precoUnitario;
    }

    public String getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

public class Pedido {
    private int numero;
    private String cpfCliente;
    private List<ItemPedido> itens;

    public Pedido(int numero, String cpfCliente) {
        this.numero = numero;
        this.cpfCliente = cpfCliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void adicionarItens(List<ItemPedido> listaItens) {
        itens.addAll(listaItens);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemPedido::calcularSubtotal).sum();
    }

    public double calcularTotalComDesconto(double descontoPercentual) {
        double total = calcularTotal();
        double desconto = total * (descontoPercentual / 100);
        return total - desconto;
    }

    public double[] calcularTotalAPrazo(int numeroPrestacoes, double juroPercentual) {
        double total = calcularTotal();
        double juro = total * (juroPercentual / 100);
        double totalAPrazo = total + juro;
        double prestacao = totalAPrazo / numeroPrestacoes;
        return new double[]{totalAPrazo, prestacao};
    }

    public void exibirInformacoes() {
        System.out.println("Pedido Nº: " + numero);
        System.out.println("CPF do Cliente: " + cpfCliente);
        System.out.println("Itens do Pedido:");
        for (ItemPedido item : itens) {
            System.out.println("   " + item.getProduto() + " - Quantidade: " + item.getQuantidade() + " - Subtotal: " + item.calcularSubtotal());
        }
        System.out.println("Total do Pedido: " + calcularTotal());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número do Pedido: ");
        int numeroPedido = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("CPF do Cliente: ");
        String cpfCliente = scanner.nextLine();

        // Criando pedido
        Pedido pedido = new Pedido(numeroPedido, cpfCliente);

        // Adicionando itens
        System.out.println("Adicione itens ao pedido (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("Produto: ");
            String produto = scanner.nextLine();
            if (produto.equalsIgnoreCase("fim")) {
                break;
            }

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            System.out.print("Preço Unitário: ");
            double precoUnitario = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha

            ItemPedido item = new ItemPedido(produto, quantidade, precoUnitario);
            pedido.adicionarItem(item);
        }

        // Exibindo informações
        pedido.exibirInformacoes();

        // Fechando o scanner
        scanner.close();
    }
}
