#include <iostream>

class Calculadora {
public:
    static double adicao(double a, double b) {
        return a + b;
    }

    static double subtracao(double a, double b) {
        return a - b;
    }

    static double multiplicacao(double a, double b) {
        return a * b;
    }

    static double divisao(double a, double b) {
        if (b == 0) {
            std::cerr << "Erro: Divisão por zero." << std::endl;
            return 0;
        }
        return a / b;
    }
};

int main() {
    double num1, num2;
    char operacao;

    std::cout << "Digite o primeiro numero: ";
    std::cin >> num1;

    std::cout << "Digite a operacao (+, -, *, /): ";
    std::cin >> operacao;

    std::cout << "Digite o segundo numero: ";
    std::cin >> num2;

    double resultado;

    switch (operacao) {
        case '+':
            resultado = Calculadora::adicao(num1, num2);
            break;
        case '-':
            resultado = Calculadora::subtracao(num1, num2);
            break;
        case '*':
            resultado = Calculadora::multiplicacao(num1, num2);
            break;
        case '/':
            resultado = Calculadora::divisao(num1, num2);
            break;
        default:
            std::cerr << "Operação inválida." << std::endl;
            return 1;
    }

    std::cout << "Resultado: " << resultado << std::endl;

    return 0;
}