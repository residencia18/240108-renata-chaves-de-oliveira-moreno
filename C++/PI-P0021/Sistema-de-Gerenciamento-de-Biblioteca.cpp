#include <iostream>
#include <vector>
#include <string>
#include <ctime>

class Livro {
private:
    static int contadorLivros;
    int id;
    std::string titulo;
    std::string autor;
    int numCopias;

public:
    Livro(std::string t, std::string a, int n) : id(contadorLivros++), titulo(t), autor(a), numCopias(n) {}

    std::string getTitulo() const { return titulo; }
    std::string getAutor() const { return autor; }
    int getNumCopias() const { return numCopias; }
    int getId() const { return id; }

    void emprestarLivro() {
        if (numCopias > 0) {
            numCopias--;
            std::cout << "Livro emprestado com sucesso!\n";
        } else {
            std::cout << "Não há cópias disponíveis para empréstimo.\n";
        }
    }

    void devolverLivro() {
        numCopias++;
        std::cout << "Livro devolvido com sucesso!\n";
    }
};

int Livro::contadorLivros = 0;

class Usuario {
private:
    static int contadorUsuarios;
    int id;
    std::string nome;
    std::vector<Livro*> livrosEmprestados;

public:
    Usuario(std::string n) : id(contadorUsuarios++), nome(n) {}

    std::string getNome() const { return nome; }
    int getId() const { return id; }

    void emprestarLivro(Livro* livro) {
        if (livro->getNumCopias() > 0) {
            livrosEmprestados.push_back(livro);
            livro->emprestarLivro();
        } else {
            std::cout << "Não foi possível emprestar o livro. Não há cópias disponíveis.\n";
        }
    }

    void devolverLivro(Livro* livro) {
        auto it = std::find(livrosEmprestados.begin(), livrosEmprestados.end(), livro);
        if (it != livrosEmprestados.end()) {
            livrosEmprestados.erase(it);
            livro->devolverLivro();
        } else {
            std::cout << "Este livro não está emprestado para você.\n";
        }
    }

    void listarLivrosEmprestados() {
        std::cout << "Livros emprestados para " << nome << ":\n";
        for (Livro* livro : livrosEmprestados) {
            std::cout << " - " << livro->getTitulo() << " por " << livro->getAutor() << "\n";
        }
    }
};

int Usuario::contadorUsuarios = 0;

class Biblioteca {
private:
    static std::vector<Livro> listaLivros;
    static std::vector<Usuario> listaUsuarios;

public:
    static void adicionarLivro(const Livro& livro) {
        listaLivros.push_back(livro);
    }

    static void adicionarUsuario(const Usuario& usuario) {
        listaUsuarios.push_back(usuario);
    }

    static void registrarEmprestimo(int idUsuario, int idLivro) {
        if (idUsuario >= 0 && idUsuario < listaUsuarios.size() && idLivro >= 0 && idLivro < listaLivros.size()) {
            Usuario& usuario = listaUsuarios[idUsuario];
            Livro& livro = listaLivros[idLivro];

            time_t now = time(0);
            tm* localTime = localtime(&now);
            std::cout << "Empréstimo registrado em: " << localTime->tm_mday << "/" << localTime->tm_mon + 1 << "/" << localTime->tm_year + 1900 << "\n";

            usuario.emprestarLivro(&livro);
        } else {
            std::cout << "Usuário ou livro inválido.\n";
        }
    }

    static void verificarDisponibilidade(int idLivro) {
        if (idLivro >= 0 && idLivro < listaLivros.size()) {
            Livro& livro = listaLivros[idLivro];
            std::cout << "Livro: " << livro.getTitulo() << "\n";
            if (livro.getNumCopias() > 0) {
                std::cout << "Disponível. Número de cópias disponíveis: " << livro.getNumCopias() << "\n";
            } else {
                std::cout << "Não disponível.\n";
            }
        } else {
            std::cout << "Livro inválido.\n";
        }
    }

    static void listarLivrosEmprestadosPorUsuario(int idUsuario) {
        if (idUsuario >= 0 && idUsuario < listaUsuarios.size()) {
            Usuario& usuario = listaUsuarios[idUsuario];
            usuario.listarLivrosEmprestados();
        } else {
            std::cout << "Usuário inválido.\n";
        }
    }

    static void devolverLivro(int idUsuario, int idLivro) {
        if (idUsuario >= 0 && idUsuario < listaUsuarios.size() && idLivro >= 0 && idLivro < listaLivros.size()) {
            Usuario& usuario = listaUsuarios[idUsuario];
            Livro& livro = listaLivros[idLivro];

            usuario.devolverLivro(&livro);
        } else {
            std::cout << "Usuário ou livro inválido.\n";
        }
    }
};

std::vector<Livro> Biblioteca::listaLivros;
std::vector<Usuario> Biblioteca::listaUsuarios;

void exibirMenu() {
    std::cout << "\n==== Sistema de Gerenciamento de Biblioteca ====\n";
    std::cout << "1. Adicionar Livro\n";
    std::cout << "2. Adicionar Usuário\n";
    std::cout << "3. Emprestar Livro\n";
    std::cout << "4. Devolver Livro\n";
    std::cout << "5. Verificar Disponibilidade de Livro\n";
    std::cout << "6. Listar Livros Emprestados por Usuário\n";
    std::cout << "7. Sair\n";
    std::cout << "Escolha uma opção: ";
}

int main() {
    int escolha;

    do {
        exibirMenu();
        std::cin >> escolha;
        std::cin.ignore(); // Limpa o buffer do teclado

        switch (escolha) {
            case 1: {
                std::string titulo, autor;
                int numCopias;

                std::cout << "Informe o título do livro: ";
                std::getline(std::cin, titulo);

                std::cout << "Informe o autor do livro: ";
                std::getline(std::cin, autor);

                std::cout << "Informe o número de cópias disponíveis: ";
                std::cin >> numCopias;
                std::cin.ignore(); // Limpa o buffer do teclado

                Livro novoLivro(titulo, autor, numCopias);
                Biblioteca::adicionarLivro(novoLivro);
                std::cout << "Livro adicionado com sucesso! ID: " << novoLivro.getId() << "\n";
                break;
            }
            case 2: {
                std::string nome;

                std::cout << "Informe o nome do usuário: ";
                std::getline(std::cin, nome);

                Usuario novoUsuario(nome);
                Biblioteca::adicionarUsuario(novoUsuario);
                std::cout << "Usuário adicionado com sucesso! ID: " << novoUsuario.getId() << "\n";
                break;
            }
            case 3: {
                int idUsuario, idLivro;

                std::cout << "Informe o ID do usuário: ";
                std::cin >> idUsuario;
                std::cout << "Informe o ID do livro: ";
                std::cin >> idLivro;

                Biblioteca::registrarEmprestimo(idUsuario, idLivro);
                break;
            }
            case 4: {
                int idUsuario, idLivro;

                std::cout << "Informe o ID do usuário: ";
                std::cin >> idUsuario;
                std::cout << "Informe o ID do livro: ";
                std::cin >> idLivro;

                Biblioteca::devolverLivro(idUsuario, idLivro);
                break;
            }
            case 5: {
                int idLivro;

                std::cout << "Informe o ID do livro: ";
                std::cin >> idLivro;

                Biblioteca::verificarDisponibilidade(idLivro);
                break;
            }
            case 6: {
                int idUsuario;

                std::cout << "Informe o ID do usuário: ";
                std::cin >> idUsuario;

                Biblioteca::listarLivrosEmprestadosPorUsuario(idUsuario);
                break;
            }
            case 7:
                std::cout << "Saindo...\n";
                break;
            default:
                std::cout << "Opção inválida. Tente novamente.\n";
                break;
        }
    } while (escolha != 7);

    return 0;
}
