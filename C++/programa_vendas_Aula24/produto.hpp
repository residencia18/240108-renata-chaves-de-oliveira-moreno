#ifndef PRODUTO_HPP
#define PRODUTO_HPP

#include <string>
#include <vector>

using namespace std;

class Produto {
    private:
        int codigo;
        string nome;
        double preco;

    public:
        Produto();
        Produto(int codigo, string nome, double preco);

        void set_codigo(int codigo);
        void set_nome(string nome);
        void set_preco(double preco);

        int get_codigo();
        string get_nome();
        double get_preco();
};

class Produtos {
    private:
        vector<Produto*> lista_produtos;

    public:
        bool insere_produto(Produto* prod);
        Produto* obter_produto (int codigo);
        int exclui_produto(int codigo);
        bool verifica_existe(int codigo);
};

#endif