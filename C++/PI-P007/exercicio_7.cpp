#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string>
#include <vector>
using namespace std;

int main() 
{
    int altura;

    //O usuário informa a altura do padrão
    cout << "Digite a altura do padrao: ";
    cin >> altura;

    char caractere = 'A'; // Começa com 'A'

    for (int linha = 1; linha <= altura; linha++) 
    {
        // Imprime os caracteres na linha atual
        for (int i = 1; i <= linha; i++)
        {
            cout << caractere;
            caractere++; // Avança para o próximo caractere
        }
        cout <<endl;
    }

    return 0;
}
