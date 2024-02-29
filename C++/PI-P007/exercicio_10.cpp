#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string>
#include <vector>
using namespace std;
#include <cmath>

int main() 
{
    int numero, numeroOriginal, resto, soma = 0, digitos = 0;

    // Solicita ao usuário que insira um número inteiro
    cout << "Digite um numero inteiro: ";
    cin >> numero;

    numeroOriginal = numero;

    // Conta o número de dígitos no número
    while (numero != 0) 
    {
        numero /= 10;
        digitos++;
    }

    numero = numeroOriginal; // Restaurar o valor original

    // Calcula a soma dos dígitos elevados à quantidade de dígitos
    while (numero != 0) 
    {
        resto = numero % 10;
        soma += std::pow(resto, digitos);
        numero /= 10;
    }

    // Verifica se o número é um número de Armstrong
    if (soma == numeroOriginal) 
    {
        cout << numeroOriginal << " e um numero de Armstrong." <<endl;
    } 
    else 
    {
        cout << numeroOriginal << " nao e um numero de Armstrong." <<endl;
    }

    return 0;
}
