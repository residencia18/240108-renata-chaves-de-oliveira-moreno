#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <iostream>
using namespace std;


char* caracteres_comuns(const char *A, const char *B) {
    int tamanho_A = strlen(A);
    int tamanho_B = strlen(B);
    
    // Alocar memória para a string C (máximo do tamanho de A ou B)
    int tamanho_C = tamanho_A < tamanho_B ? tamanho_A : tamanho_B;
    char *C = (char *)malloc((tamanho_C + 1) * sizeof(char));
    
    if (C == NULL) {
        cout<<"Erro: Falha na alocacao de memoria.";
        exit(1);
    }
    
    int indice_C = 0;
    
    for (int i = 0; i < tamanho_A; i++) 
    {
        for (int j = 0; j < tamanho_B; j++) 
        {
            if (A[i] == B[j]) 
            {
                // Verificar se o caractere já está em C
                int ja_em_C = 0;
                for (int k = 0; k < indice_C; k++) 
                {
                    if (C[k] == A[i]) 
                    {
                        ja_em_C = 1;
                        break;
                    }
                }
                
                if (!ja_em_C) 
                {
                    C[indice_C] = A[i];
                    indice_C++;
                }
            }
        }
    }
    
    C[indice_C] = '\0'; // Adicionar o terminador nulo
    return C;
}

int main() {
    const char *A = "abcdef";
    const char *B = "bcdefg";
    
    char *C = caracteres_comuns(A, B);
    
    cout<<"Caracteres comuns em A e B: "<<C;
    
    free(C); // Liberar memória alocada para C
    
    return 0;
}
