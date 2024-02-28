#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Estado {
private:
    string nome;
    string sigla;

public:
    void setNome(string _nome) {
        nome = _nome;
    }

    string getNome() {
        return nome;
    }

    void setSigla(string _sigla) {
        sigla = _sigla;
    }

    string getSigla() {
        return sigla;
    }
};

class Cidade {
private:
    string nome;
    Estado* estado;

public:
    void setNome(string _nome) {
        nome = _nome;
    }

    string getNome() {
        return nome;
    }

    void set_Estado(Estado &_estado) {
        estado = &_estado;
    }

       Estado *get_Estado() {
        return estado;
    }
};

int main(void)
{
    Estado estado_a("Bahia","BA");
    Cidade cidade;

    cidade.set_nome("Ilhéus");
    cidade.set_estado(estado_a);

    cout << "Cidade: " << cidade.get_nome() << " Estado: " << cidade.get_estado()->get_nome();
}