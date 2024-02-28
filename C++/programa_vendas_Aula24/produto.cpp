#include "produto.hpp"

// Implementação da classe Produto
//----------------------------------

Produto::Produto()
{
    this->codigo = 0;
    this->nome = "";
    this->preco = 0.0;
}

Produto::Produto(int codigo, string nome, double preco)
{
    this->codigo = codigo;
    this->nome = nome;
    this->preco = preco;
}

void Produto::set_codigo(int codigo)
{
    this->codigo = codigo;
}

void Produto::set_nome(string nome)
{
    this->nome = nome;
}

void Produto::set_preco(double preco)
{
    this->preco = preco;
}

int Produto::get_codigo()
{
    return this->codigo;
}

string Produto::get_nome()
{
    return this->nome;
}

double Produto::get_preco()
{
    return this->preco;
}

// Implementação da classe Produtos
//----------------------------------

bool Produtos::insere_produto(Produto* prod)
{
    bool existe;
    existe = verifica_existe(prod->get_codigo());
    if (existe){
        return existe;
    } else {
        this->lista_produtos.push_back(prod);
        return !existe;
    }
}

Produto* Produtos::obter_produto(int codigo)
{
    for (auto produto:lista_produtos){
        if (produto->get_codigo() == codigo){
            return produto;
        }
    }
    return NULL;
}

int Produtos::exclui_produto(int codigo)
{
    return 0;
}

bool Produtos::verifica_existe(int codigo)
{
    for (auto produto:this->lista_produtos){
        if (produto->get_codigo() == codigo){
            return true;
        }
    }
    return false;
}