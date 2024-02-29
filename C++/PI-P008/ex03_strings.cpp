#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    // Inicializa a semente para a função rand() com base no tempo atual
    srand(static_cast<unsigned int>(time(nullptr)));

    // Gera duas strings aleatórias com 10 caracteres cada
    string str1, str2;

    for (int i = 0; i < 10; i++) 
    {
        char caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str1 += caractereAleatorio;
        caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str2 += caractereAleatorio;
    }

    // Transforma o primeiro caractere de cada string em maiúscula
    str1[0] = toupper(str1[0]);
    str2[0] = toupper(str2[0]);

    // Imprime as strings em ordem alfabética
    if (str1 < str2) 
    {
        cout << str1 << endl;
        cout << str2 << endl;
    }
    else 
    {
        cout << str2 << endl;
        cout << str1 << endl;
    }

    return 0;
}
