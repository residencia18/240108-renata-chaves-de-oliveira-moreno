#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

struct Aluno 
{
    string nome;
    float nota1, nota2, media;
};

bool comparaNome(const Aluno& a, const Aluno& b) 
{
    return a.nome < b.nome;
}

void bubbleSort(vector<Aluno>& alunos) 
{
    int n = alunos.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) 
        {
            if (alunos[j].nome > alunos[j + 1].nome) 
            {
                swap(alunos[j], alunos[j + 1]);
            }
        }
    }
}

int main() 
{
    int N;
    cout << "Digite o numero maximo de alunos: ";
    cin >> N;

    vector<Aluno> alunos;

   
        Aluno novoAluno;
        
        for (int i = 0; i < N; i++)
        {
        cout << "Digite o nome do aluno: " << (i + 1) << ": ";
        cin.ignore();
        getline(cin, novoAluno.nome);
        cout << "Digite a primeira nota do aluno: " << (i + 1) << ": ";
        cin >> novoAluno.nota1;
        cout << "Digite a segunda nota do aluno: " << (i + 1) << ": ";
        cin >> novoAluno.nota2;
        novoAluno.media = (novoAluno.nota1 + novoAluno.nota2) / 2.0;

        alunos.push_back(novoAluno);
        bubbleSort(alunos);

        }

        while (true) 
        {
        char opcao;
        cout << "Deseja incluir mais alunos (s/n)? ";
        cin >> opcao;

        if (opcao == 'n' || opcao == 'N')
        {
            break;
        }

        if (alunos.size() >= N) 
        {
            cout << "Limite máximo de alunos atingido." << endl;
            continue;
        }
    }

    while (true) 
    {
        char opcao;
        cout << "\nDeseja excluir algum aluno (s/n)? ";
        cin >> opcao;

        if (opcao == 'n' || opcao == 'N') {
            break;
        }

        if (alunos.empty()) 
        {
            cout << "Nenhum aluno para excluir." << endl;
            continue;
        }

        string nomeAluno;
        cout << "Digite o nome do aluno para exlusão: ";
        cin.ignore();
        getline(cin, nomeAluno);

        auto it = find_if(alunos.begin(), alunos.end(), [&nomeAluno](const Aluno& aluno) 
        {
            return aluno.nome == nomeAluno;
        });

        if (it != alunos.end()) 
        {
            alunos.erase(it);
            cout << "Aluno excluído com sucesso." << endl;
        } 
        else 
        {
            cout << "Aluno não encontrado." << endl;
        }
    }

    while (true) 
    {
        char opcao;
        cout << "\nDeseja alterar alguma nota (s/n)? ";
        cin >> opcao;

        if (opcao == 'n' || opcao == 'N') 
        {
            break;
        }

        if (alunos.empty()) 
        {
            cout << "Nenhum aluno para alterar nota." << endl;
            continue;
        }

        string nomeAluno;
        cout << "Digite o nome do aluno para alterar a nota: ";
        cin.ignore();
        getline(cin, nomeAluno);

        auto it = find_if(alunos.begin(), alunos.end(), [&nomeAluno](const Aluno& aluno) 
        {
            return aluno.nome == nomeAluno;
        });

        if (it != alunos.end()) 
        {
            cout << "Notas atuais do aluno " << nomeAluno <<
             ": Nota 1: " << it->nota1 << ", Nota 2: " << it->nota2 << endl;

            while (true) 
            {
                int opcaoNota;
                cout << "Alterar a primeira nota (1), a segunda nota (2) ou nenhuma (0)? ";
                cin >> opcaoNota;

                if (opcaoNota == 0) 
                {
                    break;
                } 
                else if (opcaoNota == 1) 
                {
                    cout << "Informe a nova primeira nota: ";
                    cin >> it->nota1;
                } 
                else if (opcaoNota == 2) 
                {
                    cout << "Informe a nova segunda nota: ";
                    cin >> it->nota2;
                } 
                else
                {
                    cout << "Opcao invalida. Tente novamente." << endl;
                }

                it->media = (it->nota1 + it->nota2) / 2.0;
                cout << "Notas atualizadas do aluno " << 
                nomeAluno << ": Nota 1: " << it->nota1 << ", Nota 2: " << it->nota2 << endl;
            }
        } 
        else 
        {
            cout << "Aluno nao encontrado." << endl;
        }
    }

    cout << "\nLista de alunos e suas notas:" << endl;
    for (const auto& aluno : alunos) 
    {
        cout<<"Aluno: " << aluno.nome<<endl;
        cout<<"Nota 1: "<<aluno.nota1<<endl;
        cout<<"Nota 2: "<<aluno.nota2<<endl;
        cout<<"Media: " << aluno.media;
        if (aluno.media >= 7.0) 
        {
            cout << " (Aprovado)";
        } 
        else 
        {
            cout << " (Reprovado)";
        }
        cout <<endl<<endl;
    }

    return 0;
}
