#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
using namespace std;


bool ehPrimo(int numero) 
{
    if (numero <= 1) 
    {
        return false; // Números menores ou iguais a 1 não são primos
    }

    for (int i = 2; i * i <= numero; i++) 
    {
        if (numero % i == 0) 
        {
            return false; // Encontrou um divisor, não é primo
        }
    }

    return true; // Não encontrou divisores, é primo
}

int main() 
{
    cout << "Numeros primos de 1 a 100:" <<endl;

    for (int i = 1; i <= 100; i++) 
    {
        if (ehPrimo(i)) 
        {
         cout << i << " ";
        }
    }

    cout<<endl;

    return 0;
}
