#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;

float calc_serie(int N) 
{
    if (N <= 0) 
    {
        cout<<"N deve ser um número inteiro positivo.";
        return -1.0; // Valor inválido
    }
    
    float S = 0.0;
    
    S = (1/N) + (2/(N-1)) + (3/(N-2)) + ((N-1)/2) + (N/1);

    return S;
}

int main() {
    int N;
    
    cout<<"Digite o valor de N: ";
    cin>>N;
    
    float resultado = calc_serie(N);
    
    if (resultado != -1.0)
    {
        cout<<"O valor da serie S e: "<<resultado<<endl;
    }
    
    return 0;
}
