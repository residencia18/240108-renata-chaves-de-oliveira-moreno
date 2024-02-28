#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Pessoa
{
protected:
    string nome;

public:
    Pessoa(const string &nome) : nome(nome) {}

    string getNome() const { return nome; }
    void setNome(const string &novoNome) { nome = novoNome; }
};

class Paciente : public Pessoa
{
private:
    string cpf;
    string dataNascimento;

public:
    Paciente(const string &nome, const string &cpf, const string &dataNascimento)
        : Pessoa(nome), cpf(cpf), dataNascimento(dataNascimento) {}

    string getCPF() const { return cpf; }
    string getDataNascimento() const { return dataNascimento; }

    void setDataNascimento(const string &novaDataNascimento) { dataNascimento = novaDataNascimento; }
};

class Medico : public Pessoa
{
private:
    string crm;

public:
    Medico(const string &nome, const string &crm)
        : Pessoa(nome), crm(crm) {}

    string getCRM() const { return crm; }
};

class ClinicaMedica
{
private:
    vector<Paciente> pacientes;
    vector<Medico> medicos;

public:
    void incluirPaciente(const Paciente &paciente)
    {
        pacientes.push_back(paciente);
    }

    void excluirPaciente(const string &cpf)
    {
        for (auto it = pacientes.begin(); it != pacientes.end(); ++it)
        {
            if (it->getCPF() == cpf)
            {
                pacientes.erase(it);
                break;
            }
        }
    }

    void alterarPaciente(const string &cpf)
    {
        for (Paciente &paciente : pacientes)
        {
            if (paciente.getCPF() == cpf)
            {
                cout << "Deseja alterar o nome do paciente? (S/N): ";
                char opcao;
                cin >> opcao;
                cin.ignore();
                if (opcao == 'S' || opcao == 's')
                {
                    cout << "Novo nome: ";
                    string novoNome;
                    getline(cin, novoNome);
                    paciente.setNome(novoNome);
                }

                cout << "Nova data de nascimento: ";
                string novaDataNascimento;
                getline(cin, novaDataNascimento);
                paciente.setDataNascimento(novaDataNascimento);
                break;
            }
        }
    }

    void listarPacientes()
    {
        for (const Paciente &paciente : pacientes)
        {
            cout << "Nome: " << paciente.getNome() << ", CPF: " << paciente.getCPF()
                 << ", Data de Nascimento: " << paciente.getDataNascimento() << endl;
        }
    }

    Paciente localizarPaciente(const string &cpf)
    {
        for (const Paciente &paciente : pacientes)
        {
            if (paciente.getCPF() == cpf)
            {
                return paciente;
            }
        }
        throw runtime_error("Paciente nao encontrado.");
    }

    void incluirMedico(const Medico &medico)
    {
        medicos.push_back(medico);
    }

    void excluirMedico(const string &crm)
    {
        for (auto it = medicos.begin(); it != medicos.end(); ++it)
        {
            if (it->getCRM() == crm)
            {
                medicos.erase(it);
                break;
            }
        }
    }

    void alterarMedico(const string &crm)
    {
        for (Medico &medico : medicos)
        {
            if (medico.getCRM() == crm)
            {
                cout << "Deseja alterar o nome do médico? (S/N): ";
                char opcao;
                cin >> opcao;
                cin.ignore();
                if (opcao == 'S' || opcao == 's')
                {
                    cout << "Novo nome: ";
                    string novoNome;
                    getline(cin, novoNome);
                    medico.setNome(novoNome);
                }
                break;
            }
        }
    }

    void listarMedicos()
    {
        for (const Medico &medico : medicos)
        {
            cout << "Nome: " << medico.getNome() << ", CRM: " << medico.getCRM() << endl;
        }
    }

    Medico localizarMedico(const string &crm)
    {
        for (const Medico &medico : medicos)
        {
            if (medico.getCRM() == crm)
            {
                return medico;
            }
        }
        throw runtime_error("Medico nao encontrado.");
    }
};

int main()
{
    system("cls");

    ClinicaMedica clinicaMedica;

    while (true)
    {
        cout << "\nBEM VINDO (A) A CLINICA MEDICA SEM DODOI LTDA.\n"
             << endl;
        cout << "-------------------- MENU --------------------\n"
             << endl;
        cout << "1. Incluir Paciente" << endl;
        cout << "2. Excluir Paciente" << endl;
        cout << "3. Alterar Paciente" << endl;
        cout << "4. Listar Pacientes" << endl;
        cout << "5. Localizar Paciente" << endl;
        cout << "6. Incluir Medico" << endl;
        cout << "7. Excluir Medico" << endl;
        cout << "8. Alterar Medico" << endl;
        cout << "9. Listar Medicos" << endl;
        cout << "10. Localizar Medico\n"
             << endl;
        cout << "0. Sair\n"
             << endl;
        int escolha;
        cin >> escolha;

        if (escolha == 0)
        {
            break;
        }
        else if (escolha == 1)
        {
            string nome, cpf, dataNascimento;
            cout << "Nome: ";
            cin.ignore();
            getline(cin, nome);
            cout << "CPF: ";
            cin >> cpf;
            cout << "Data de Nascimento: ";
            cin.ignore();
            getline(cin, dataNascimento);
            Paciente novoPaciente(nome, cpf, dataNascimento);
            clinicaMedica.incluirPaciente(novoPaciente);
        }
        else if (escolha == 2)
        {
            string cpf;
            cout << "CPF do paciente a ser excluido: ";
            cin >> cpf;
            clinicaMedica.excluirPaciente(cpf);
        }
        else if (escolha == 3)
        {
            string cpf;
            cout << "CPF do paciente a ser alterado: ";
            cin >> cpf;
            clinicaMedica.alterarPaciente(cpf);
        }
        else if (escolha == 4)
        {
            clinicaMedica.listarPacientes();
        }
        else if (escolha == 5)
        {
            string cpf;
            cout << "CPF do paciente a ser localizado: ";
            cin >> cpf;
            try
            {
                Paciente paciente = clinicaMedica.localizarPaciente(cpf);
                cout << "Paciente encontrado: Nome - " << paciente.getNome()
                     << ", CPF - " << paciente.getCPF() << ", Data de Nascimento - "
                     << paciente.getDataNascimento() << endl;
            }
            catch (const runtime_error &e)
            {
                cout << e.what() << endl;
            }
        }
        else if (escolha == 6)
        {
            string nome, crm;
            cout << "Nome do Medico: ";
            cin.ignore();
            getline(cin, nome);
            cout << "CRM: ";
            cin >> crm;
            Medico novoMedico(nome, crm);
            clinicaMedica.incluirMedico(novoMedico);
        }
        else if (escolha == 7)
        {
            string crm;
            cout << "CRM do medico a ser excluído: ";
            cin >> crm;
            clinicaMedica.excluirMedico(crm);
        }
        else if (escolha == 8)
        {
            string crm;
            cout << "CRM do medico a ser alterado: ";
            cin >> crm;
            clinicaMedica.alterarMedico(crm);
        }
        else if (escolha == 9)
        {
            clinicaMedica.listarMedicos();
        }
        else if (escolha == 10)
        {
            string crm;
            cout << "CRM do medico a ser localizado: ";
            cin >> crm;
            try
            {
                Medico medico = clinicaMedica.localizarMedico(crm);
                cout << "Medico encontrado: Nome - " << medico.getNome() << ", CRM - " << medico.getCRM() << endl;
            }
            catch (const runtime_error &e)
            {
                cout << e.what() << endl;
            }
        }
    }

    return 0;
}