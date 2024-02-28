#include "Paciente.h"
#include <iostream>

Paciente::Paciente(std::string _nome, std::string _cpf, std::string _dataNascimento) : nome(_nome), cpf(_cpf), dataNascimento(_dataNascimento) {}

void cadastrarPaciente(std::vector<Paciente>& pacientes) {
    std::string nome, cpf, dataNascimento;
    std::cout << "Nome do paciente: ";
    std::cin >> nome;
    std::cout << "CPF do paciente: ";
    std::cin >> cpf;
    std::cout << "Data de nascimento do paciente: ";
    std::cin >> dataNascimento;
    pacientes.push_back(Paciente(nome, cpf, dataNascimento));
    std::cout << "Paciente cadastrado com sucesso!" << std::endl;
}

void excluirPaciente(std::vector<Paciente>& pacientes) {
    std::string cpf;
    std::cout << "CPF do paciente a ser excluído: ";
    std::cin >> cpf;
    for (size_t i = 0; i < pacientes.size(); i++) {
        if (pacientes[i].cpf == cpf) {
            pacientes.erase(pacientes.begin() + i);
            std::cout << "Paciente excluído com sucesso!" << std::endl;
            return;
        }
    }
    std::cout << "Paciente não encontrado." << std::endl;
}

void listarPacientes(const std::vector<Paciente>& pacientes) {
    std::cout << "Lista de pacientes:" << std::endl;
    for (const Paciente& paciente : pacientes) {
        std::cout << "Nome: " << paciente.nome << " | CPF: " << paciente.cpf << " | Data de Nascimento: " << paciente.dataNascimento << std::endl;
    }
}
