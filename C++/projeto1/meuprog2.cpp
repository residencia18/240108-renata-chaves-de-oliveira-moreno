#include <iostream>

using namespace std;

float main() {
    int A, B;

    cout << "Digite o valor de A: ";
    cin >> A;

    cout << "Digite o valor de B: ";
    cin >> B;

    float soma = A + B;
    float subtracao = A - B;
    float multiplicacao = A * B;
    float divisao = A / B;
    float resto = A % B;

    cout << "Soma = " << soma << endl;
    cout << "Subtração = " << subtracao << endl;
    cout << "Multiplicação = " << multiplicacao << endl;
    cout << "Divisão = " << divisao << endl;
    cout << "Resto = " << resto << endl;

    return 0;
}