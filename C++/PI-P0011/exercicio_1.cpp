#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

void maxmin(int vetor[], int n, int &maximo, int &minimo);

int main()
{
    int tamanho = 7,maximo,minimo;
    int v[] = {9,4,1,2,3,6,5};

    maxmin(v,tamanho,maximo,minimo);

    cout<<"O maior e: "<<maximo<<endl;
    cout<<"O menor e: "<<minimo;
    

}

void maxmin(int vetor[], int n, int &maximo, int &minimo)
{
    minimo = vetor[0];
    maximo = vetor[0];
    for(int i = 1; i < n; i++)
    {
        if (vetor[i] > maximo)
        {
            maximo = vetor[i];  
        }
        if (vetor[i] < minimo) 
        {
            minimo = vetor[i];  
        }
    }
}