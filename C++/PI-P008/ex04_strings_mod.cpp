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
    string str1,str2,str3,str4,str5,str6,str7,str8,str9,str10;

    for (int i = 0; i < 10; i++) 
    {
        char caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str1 += caractereAleatorio;
        caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str2 += caractereAleatorio;
        caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str3 += caractereAleatorio;
        caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str4 += caractereAleatorio;
        caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str5 += caractereAleatorio;
        caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str6 += caractereAleatorio;
        caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str7 += caractereAleatorio;
        caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str8 += caractereAleatorio;
        caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str9 += caractereAleatorio;
        caractereAleatorio = 'a' + rand() % ('z' - 'a' + 1);
        str10 += caractereAleatorio;
    }

    // Transforma o primeiro caractere de cada string em maiúscula
    str1[0] = toupper(str1[0]);
    str2[0] = toupper(str2[0]);
    str3[0] = toupper(str2[0]);
    str4[0] = toupper(str2[0]);
    str5[0] = toupper(str2[0]);
    str6[0] = toupper(str2[0]);
    str7[0] = toupper(str2[0]);
    str8[0] = toupper(str2[0]);
    str9[0] = toupper(str2[0]);
    str10[0] = toupper(str2[0]);

    // Imprime as strings em ordem alfabética
    if (str1 < str2) 
    {
        cout << str1 << endl;
        cout << str2 << endl;
        cout << str3 << endl;
        cout << str4 << endl;
        cout << str5 << endl;
        cout << str6 << endl;
        cout << str7 << endl;
        cout << str8 << endl;
        cout << str9 << endl;
        cout << str10 << endl;
    }
    else 
    {
        cout << str10 << endl;
        cout << str9 << endl;
        cout << str8 << endl;
        cout << str7 << endl; 
        cout << str6 << endl; 
        cout << str5 << endl;
        cout << str4 << endl;
        cout << str3 << endl;
        cout << str2 << endl;
        cout << str1 << endl;
    }

    return 0;
}
