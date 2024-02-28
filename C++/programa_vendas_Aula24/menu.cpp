#include "menu.hpp"

void limpa_tela(){
    system("clear");
}

void mostrar_menu(vector<string> itens_menu){
    limpa_tela();
    cout << "Opções disponíveis: " << endl;
    for(auto item:itens_menu){
        cout << item << endl;
    }
}

int obter_opcao(int tam){
    int opcao;
    while(true){
        cout << "Digite a sua opcao: ";
        cin >> opcao;
        if (opcao >= 1 && opcao <= 9){
            return opcao;
        } else {
            cout << endl << "Opcao Invalida! Sua opcao deve estar entre 1 e " << tam << endl;
        }
    }
}