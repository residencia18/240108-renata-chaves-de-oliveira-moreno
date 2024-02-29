#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

void calcula(int &X, int &Y) 
{
    int soma = X + Y;
    int subtracao = X - Y;

    X = soma; 
    Y = subtracao; 
}

int main() 
{
    int X, Y;

    cout << "Digite o valor de X: ";
    cin >> X;
    cout << "Digite o valor de Y: ";
    cin >> Y;

    calcula(X, Y);

    cout << "X (soma): " << X <<endl;
    cout << "Y (subtração): " << Y <<endl;

    return 0;
}
