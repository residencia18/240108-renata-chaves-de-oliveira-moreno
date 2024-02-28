#include <iostream>
#include <string>

int main() {
    std::string nome_do_usuario;

    std::cout << "Digite seu nome: ";
    std::cin >> nome_do_usuario;

    std::cout << "Bom dia, " << nome_do_usuario << "!" << std::endl;

    return 0;
}