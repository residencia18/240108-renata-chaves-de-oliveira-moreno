/*
Programa Vendas

programa que vai permitir ao usuário
1. Incluir um produto
2. Excluir um produto
3. Alterar um produto
4. Listar todos os produtos
5. Realizar uma venda
6. Listar todas as vendas
7. Mostrar uma venda a partir de um código
8. Mostrar total faturado  
9. Sair

*/

#include "menu.hpp"
#include "produto.hpp"

int main(int argc, char const *argv[])

{

    vector<string> itens_menu = {
        "[1] Incluir um produto", 
        "[2] Excluir um produto",
        "[3] Alterar um produto",
        "[4] Listar todos os produtos",
        "[5] Realizar uma venda",
        "[6] Listar todas as vendas",
        "[7] Mostrar uma venda a partir de um código",
        "[8] Mostrar total faturado",
        "[9] Sair"
        };

    int opcao;

    Produto produto1(1, "Feijao", 12.00);
    Produto produto2;
    Produtos produtos;
    produtos.insere_produto(&produto1);
    produto2 = *produtos.obter_produto(1);

    cout << "Cod: " << produto2.get_codigo() << endl;
    cout << "Nome: " << produto2.get_nome() << endl;
    cout << "Preco: " << produto2.get_preco() << endl;
    /* while(true){
        mostrar_menu(itens_menu);
        opcao = obter_opcao(itens_menu.size());
        switch (opcao)
        {
        case 1:
            incluir_produto(produtos);
            break;
        case 2:
            excluir_produto(produtos);
            break;
        case 3:
            alterar_produto(produtos);        
            break;
        case 4:
            listar_produtos(produtos);
            break;
        case 5:
            realizar_venda(vendas);
            break;
        case 6:
            listar_vendas(vendas);
            break;
        case 7:
            mostrar_venda(vendas);
            break;
        case 8:
            mostrar_faturado(vendas);
            break; 
        case 9:
            exit(0);
            break;
        
        default:
            break;
        }
    }*/
}