#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <cmath>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;


class Produto 
{
public:
    Produto(string nome, int codigo, double preco) 
        : nome(nome), codigo(codigo), preco(preco) {}

    string getNome() const { return nome; }
    int getCodigo() const { return codigo; }
    double getPreco() const { return preco; }

private:
    string nome;
    int codigo;
    double preco;
};

class Estoque 
{
public:
    void adicionarProduto(const Produto& produto, int quantidade) 
    {
        produtos.push_back(produto);
        quantidades.push_back(quantidade);
    }

    int buscarProduto(int codigo) 
    {
        for (int i = 0; i < produtos.size(); ++i) 
        {
            if (produtos[i].getCodigo() == codigo) 
            {
                return i;
            }
        }
        return -1; // Produto não encontrado
    }

    bool removerProduto(int codigo, int quantidade) 
    {
        int index = buscarProduto(codigo);
        if (index != -1 && quantidades[index] >= quantidade) 
        {
            quantidades[index] -= quantidade;
            return true;
        }
        return false; // Produto não encontrado ou quantidade insuficiente
    }

    void listarProdutos() 
    {
        cout << "Produtos no estoque:\n";
        for (int i = 0; i < produtos.size(); ++i) 
        {
            cout << "Codigo: " << produtos[i].getCodigo() << ", Nome: " << produtos[i].getNome()
                 << ", Preco: " << produtos[i].getPreco() << ", Quantidade: " << quantidades[i] << "\n";
        }
    }

private:
    vector<Produto> produtos;
    vector<int> quantidades;
};

class CarrinhoDeCompras {
public:
    void adicionarProduto(const Produto& produto, int quantidade) 
    {
        produtos.push_back(produto);
        quantidades.push_back(quantidade);
    }

    bool removerProduto(int codigo) 
    {
        int index = buscarProduto(codigo);
        if (index != -1) 
        {
            produtos.erase(produtos.begin() + index);
            quantidades.erase(quantidades.begin() + index);
            return true;
        }
        return false; // Produto não encontrado no carrinho
    }

    double calcularValorTotal() 
    {
        double total = 0;
        for (int i = 0; i < produtos.size(); ++i) 
        {
            total += produtos[i].getPreco() * quantidades[i];
        }
        return total;
    }

    void listarProdutos() 
    {
        cout << "Produtos no carrinho:\n";
        for (int i = 0; i < produtos.size(); ++i) {
            cout << "Codigo: " << produtos[i].getCodigo() << ", Nome: " << produtos[i].getNome()
                 << ", Preco: " << produtos[i].getPreco() << ", Quantidade: " << quantidades[i] << "\n";
        }
    }

private:
    vector<Produto> produtos;
    vector<int> quantidades;

    int buscarProduto(int codigo) 
    {
        for (int i = 0; i < produtos.size(); ++i) 
        {
            if (produtos[i].getCodigo() == codigo)
            {
                return i;
            }
        }
        return -1; // Produto não encontrado no carrinho
    }
};

int main() {
    Produto p1("Arroz", 101, 5.0);
    Produto p2("Feijao", 102, 3.5);
    Produto p3("Macarrao", 103, 2.0);

    Estoque estoque;
    estoque.adicionarProduto(p1, 50);
    estoque.adicionarProduto(p2, 30);
    estoque.adicionarProduto(p3, 40);

    CarrinhoDeCompras carrinho;

    carrinho.adicionarProduto(p1, 2);
    carrinho.adicionarProduto(p2, 3);

    cout << "Estoque inicial:\n";
    estoque.listarProdutos();

    cout << "\nCarrinho de compras inicial:\n";
    carrinho.listarProdutos();

    cout << "\nValor total no carrinho: " << carrinho.calcularValorTotal() << endl;

    return 0;
}
