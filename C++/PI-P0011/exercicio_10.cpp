#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
using namespace std;

int* encontra_letra(const char *str, char letra, int *tamanho) {
    int str_len = strlen(str);
    int *indices = NULL;
    int cont = 0;
    
    for (int i = 0; i < str_len; i++) 
    {
        if (str[i] == letra) 
        {
            cont++;
            // Aloca ou realoca o vetor de índices
            indices = (int*)realloc(indices, cont * sizeof(int));
            indices[cont - 1] = i; // Armazena o índice onde a letra foi encontrada
        }
    }
    
    *tamanho = cont; // Atualiza o tamanho do vetor
    
    return indices;
}

int main() 
{
    const char *minha_string = "exemplo de uma string de teste";
    char letra = 'e';
    
    int tamanho;
    int *indices = encontra_letra(minha_string, letra, &tamanho);
    
    cout<<"Posicoes onde a letra foi encontrada: "<<letra;
    for (int i = 0; i < tamanho; i++) 
    {
        cout<<" "<<indices[i];
    }
    cout<<endl;
    
    // Libera a memória alocada para o vetor de índices
    free(indices);
    
    return 0;
}
