/*Crie a sobrecarga do operador = para atribuir a um conjunto os mesmos itens que 
estão no outro 
A=B; //A recebe os itens de B 
Considere a criação de um construtor de conjuntos que recebe outro 
conjunto como parâmetro 
Crie a sobrecarga do operador + para executar a união entre dois conjuntos 
A = B+C; //A recebe todos os itens de B e ainda os de C que não se repetem 
em B 
Crie a sobrecarga do operador * para executar a intersecção entre dois conjuntos 
A = B*C; //A recebe os itens de B que ocorrem também em C 
Crie a sobrecarga do operador - para calcular a diferença entre dois conjuntos 
A = B-C; //A recebe os itens que estão em B mas não estão em C 
Crie a sobrecarga do operador <> para calcular o delta entre dois conjuntos 
A = B<>C; //A recebe a união entre os itens que estão em B mas não em C, 
além dos elementos que estão em C mas não em B 
Crie a sobrecarga do operador == para permitir a comparação entre dois conjuntos 
A==B dá true se todos os elementos de A estão em B e vice versa. Retorna 
false caso contrário. 
*/
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class ItemSet {
private:
    vector<string> items;

public:
    ItemSet() {}

    ItemSet(const ItemSet& other) : items(other.items) {}

    void inserir(string s) {
        for (const string& item : items) {
            if (item == s) {
                cout << "O item já existe no conjunto." << endl;
                return;
            }
        }
        items.push_back(s);
        cout << "Item inserido com sucesso." << endl;
    }

    void excluir(string s) {
        auto it = find(items.begin(), items.end(), s);
        if (it != items.end()) {
            items.erase(it);
            cout << "Item excluído com sucesso." << endl;
        } else {
            cout << "O item não existe no conjunto." << endl;
        }
    }

    ItemSet& operator=(const ItemSet& other) {
        if (this == &other)
            return *this;

        items = other.items;
        return *this;
    }

    ItemSet operator+(const ItemSet& other) const {
        ItemSet result(*this);
        for (const string& item : other.items) {
            result.inserir(item);
        }
        return result;
    }

    ItemSet operator*(const ItemSet& other) const {
        ItemSet result;
        for (const string& item : items) {
            if (other.contem(item)) {
                result.inserir(item);
            }
        }
        return result;
    }

    ItemSet operator-(const ItemSet& other) const {
        ItemSet result(*this);
        for (const string& item : other.items) {
            result.excluir(item);
        }
        return result;
    }

    ItemSet operator^(const ItemSet& other) const {
        ItemSet result;
        for (const string& item : items) {
            if (!other.contem(item)) {
                result.inserir(item);
            }
        }
        for (const string& item : other.items) {
            if (!contem(item)) {
                result.inserir(item);
            }
        }
        return result;
    }

    bool operator==(const ItemSet& other) const {
        return is_permutation(items.begin(), items.end(), other.items.begin(), other.items.end());
    }

    bool contem(string s) const {
        return find(items.begin(), items.end(), s) != items.end();
    }

    void mostrarItens() const {
        for (const string& item : items) {
            cout << item << " ";
        }
        cout << endl;
    }

    friend ostream& operator<<(ostream& os, const ItemSet& conjunto) {
        for (const string& item : conjunto.items) {
            os << item << " ";
        }
        return os;
    }
};

int main() {
    ItemSet A, B, C;

    A.inserir("item1");
    A.inserir("item2");
    A.inserir("item3");

    B.inserir("item2");
    B.inserir("item3");
    B.inserir("item4");

    C.inserir("item3");
    C.inserir("item4");
    C.inserir("item5");

    ItemSet D = B + C;
    cout << "D: " << D << endl;

    ItemSet E = B * C;
    cout << "E: " << E << endl;

    ItemSet F = B - C;
    cout << "F: " << F << endl;

    ItemSet G = B ^ C;  // Delta entre B e C
    cout << "G: " << G << endl;

    if (A == B) {
        cout << "A e B são iguais." << endl;
    } else {
        cout << "A e B não são iguais." << endl;
    }

    return 0;
}