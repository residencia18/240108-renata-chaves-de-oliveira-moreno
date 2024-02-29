#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;

int* intercala(int *vet1, int tam1, int *vet2, int tam2) {
    int tamanho_resultante = tam1 + tam2;
    int *resultado = (int *)malloc(tamanho_resultante * sizeof(int));
    
    if (resultado == NULL) {
        cout<<"Erro: Não foi possivel alocar memoria."<<endl;
        exit(1);
    }
    
    int indice_vet1 = 0, indice_vet2 = 0;
    
    for (int i = 0; i < tamanho_resultante; i++)
     {
        if (indice_vet1 < tam1) 
        {
            resultado[i] = vet1[indice_vet1];
            indice_vet1++;
        }
        else 
        {
            resultado[i] = vet2[indice_vet2];
            indice_vet2++;
        }
    }
    
    return resultado;
}

int main()
 {
    int vet1[] = {1, 3, 5};
    int tam1 = 3;
    
    int vet2[] = {2, 4, 6};
    int tam2 = 3;
    
    int *resultado = intercala(vet1, tam1, vet2, tam2);
    
    cout<<"Vetor intercalado: ";
    for (int i = 0; i < (tam1 + tam2); i++) 
    {
        cout<<" "<<resultado[i];
    }
    cout<<endl;
    
    // Liberar a memória alocada para o resultado
    free(resultado);
    
    return 0;
}
