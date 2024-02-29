#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
using namespace std;


int main() 
{
    int numero, reverso = 0, original, digito;

    // Solicita ao usuário que insira um número
    cout << "Digite um numero inteiro: ";
    cin >> numero;

    original = numero; // Salva uma cópia do número original

    // Inverte o número digitado
    while (numero > 0) 
    {
        digito = numero % 10;
        reverso = reverso * 10 + digito;
        numero /= 10;
    }

    // Verifica se o número é um palíndromo
    if (original == reverso) 
    {
        cout << original << " e um numero palindromo." <<endl;
    } 
    else 
    {
        cout << original << " nao um numero palindromo." <<endl;
    }

    return 0;
}



