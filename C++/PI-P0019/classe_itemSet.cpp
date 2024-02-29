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

class itemSet
{
  vector<string> item;

  

public:
    
    void inserir(const string& s) 
    {
   
        if (std::find(item.begin(), item.end(), s) == item.end()) 
        {
            item.push_back(s);
            cout << "Item \"" << s << "\" inserido no conjunto." << endl;
        } 
        else 
        {
            cout << "Item \"" << s << "\" ja existe no conjunto." << endl;
        }
    }

    // Método para excluir um item do conjunto, caso ele exista
    void excluir(const string& s) 
    {
        auto it = std::find(item.begin(), item.end(), s);
        if (it != item.end()) 
        {
            item.erase(it);
            cout << "Item \"" << s << "\" excluido do conjunto." <<endl;
        } 
        else 
        {
         cout << "Item \"" << s << "\" nao encontrado no conjunto." <<endl;
        }
    }

    // Método para imprimir todos os itens do conjunto
    void imprimir() const 
    {
        cout << "Itens no conjunto:";
        for (const string& item : item) 
        {
            cout << " " << item;
        }
        cout<<endl;
    }
};

int main() 
{
    itemSet conjunto;

    conjunto.inserir("item1");
    conjunto.inserir("item2");
    conjunto.inserir("item3");
    conjunto.inserir("item2"); 

    conjunto.imprimir();

    conjunto.excluir("item3");
    conjunto.excluir("item4"); 

    conjunto.imprimir();

    return 0;
}
