#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <iostream>
using namespace std;

char* codifica(const char *entrada) {
    int len = strlen(entrada);
    char *codificada = (char *)malloc((len + 1) * sizeof(char));
    
    if (codificada == NULL) {
        printf("Erro: Falha na alocação de memória.\n");
        exit(1);
    }
    
    for (int i = 0; i < len; i++) 
    {
        char c = entrada[i];
        if (isalpha(c)) 
        {
            if (c == 'z') 
            {
                codificada[i] = 'a';
            } 
            else if (c == 'Z') 
            {
                codificada[i] = 'A';
            } 
            else 
            {
                codificada[i] = c + 1;
            }
        } 
        else 
        {
            codificada[i] = c; // Caracteres não alfabéticos permanecem inalterados
        }
    }
    
    codificada[len] = '\0'; // Adiciona o terminador nulo
    return codificada;
}

char* decodifica(const char *codificada) 
{
    int len = strlen(codificada);
    char *decodificada = (char *)malloc((len + 1) * sizeof(char));
    
    if (decodificada == NULL) 
    {
        printf("Erro: Falha na alocacao de memoria.\n");
        exit(1);
    }
    
    for (int i = 0; i < len; i++) 
    {
        char c = codificada[i];
        if (isalpha(c)) 
        {
            if (c == 'a') 
            {
                decodificada[i] = 'z';
            } 
            else if (c == 'A') 
            {
                decodificada[i] = 'Z';
            } 
            else 
            {
                decodificada[i] = c - 1;
            }
        } 
        else 
        {
            decodificada[i] = c; // Caracteres não alfabéticos permanecem inalterados
        }
    }
    
    decodificada[len] = '\0'; // Adiciona o terminador nulo
    return decodificada;
}

int main() {
    const char *entrada = "Estruturas de Dados";
    
    char *codificada = codifica(entrada);
    cout<<"String codificada: "<<codificada<<endl;
    
    char *decodificada = decodifica(codificada);
    cout<<"String decodificada: "<<decodificada;
    
    // Liberar memória alocada
    free(codificada);
    free(decodificada);
    
    return 0;
}
