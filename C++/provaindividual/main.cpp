#include <iostream>
#include <vector>
#include "Paciente.h"
#include "Medico.h"
#include "Consulta.h"

using namespace std;

int main() {
    vector<Paciente> pacientes;
    vector<Medico> medicos;
    vector<Consulta> consultas;

    int opcao;
    do {
        cout << "Menu Principal:" << endl;
        cout << "1. Gestão de Pacientes" << endl;
        cout << "2. Gestão de Médicos" << endl;
        cout << "3. Gestão de Consultas" << endl;
        cout << "0. Sair do Programa" << endl;
        cout << "Escolha a opção: ";
        cin >> opcao;

        switch (opcao) {
            case 1:
                gestaoPacientes(pacientes);
                break;
            case 2:
                gestaoMedicos(medicos);
                break;
            case 3:
                gestaoConsultas(pacientes, medicos, consultas);
                break;
            case 0:
                break;
            default:
                cout << "Opção inválida." << endl;
        }
    } while (opcao != 0);

    return 0;
}
