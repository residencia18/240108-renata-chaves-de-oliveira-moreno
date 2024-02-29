#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

void ordenarCrescente(float &a, float &b, float &c, float &d) {
    if (a > b) {
        swap(a, b);
    }
    if (a > c) {
        swap(a, c);
    }
    if (a > d) {
        swap(a, d);
    }
    if (b > c) {
        swap(b, c);
    }
    if (b > d) {
        swap(b, d);
    }
    if (c > d) {
        swap(c, d);
    }
}

int main() {
    float num1, num2, num3, num4;

    cout << "Digite quatro números float: ";
    cin >> num1 >> num2 >> num3 >> num4;

    ordenarCrescente(num1, num2, num3, num4);

    cout << "Números em ordem crescente: " << num1 << " " << num2 << " " << num3 << " " << num4 <<endl;

    return 0;
}
