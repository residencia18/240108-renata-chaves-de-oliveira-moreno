#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
using namespace std;

int main()
{

    int numero;

    cout<<"Digite um numero inteiro: ";
    cin>>numero;

    for (int i = 1; i <= numero; i++) 
    {
        if (numero % i == 0) //Verifica as divisoes com resto 0 e informa seus divisores
         {
            cout<<i<<" ";
         }
    }

    return 0;
}
