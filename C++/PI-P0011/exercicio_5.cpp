#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

#include <stdio.h>

int insere_meio(int *vetor, int qtde, int elemento) 
{
    if (qtde < 0) 
    {
        cout<<"Erro: Quantidade inválida."<<endl;
        return -1;
    }
    
    
    int meio = qtde / 2;
    
   
    for (int i = qtde; i > meio; i--) 
    {
        vetor[i] = vetor[i - 1];
    }
    
   
    vetor[meio] = elemento;
    
    
    return qtde + 1;
}

int main() {
    int vetor[100]; 
    int qtde = 6;   
    
    for (int i = 0; i < qtde; i++) 
    {
        vetor[i] = i + 1;
    }
    
    cout<<"Vetor original: ";
    for (int i = 0; i < qtde; i++) 
    {
        cout<<" "<<vetor[i];
    }
    cout<<endl;
    
    int elemento = 100;
    qtde = insere_meio(vetor, qtde, elemento);
    
    if (qtde != -1) {
        cout<<"Vetor após a inserção: "<<endl;
        for (int i = 0; i < qtde; i++) 
        {
            cout<<" "<<vetor[i];
        }
        cout<<endl;
    }
    
    return 0;
}
