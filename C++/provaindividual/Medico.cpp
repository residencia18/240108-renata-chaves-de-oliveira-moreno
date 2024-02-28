#include "Medico.h"
#include <iostream>

Medico::Medico(std::string _nome, std::string _crm) : nome(_nome), crm(_crm) {}

void cadastrarMedico(std::vector<Medico>& medicos) {
    std::string nome, crm;
    std::cout << "Nome do médico: ";
    std::cin >> nome;
    std::cout << "CRM do médico: ";
    std::cin >> crm;
    medicos.push_back(Medico(nome, crm));
    std::cout << "Médico cadastrado com sucesso!" << std::endl;
}

void excluirMedico(std::vector<Medico>& medicos) {
    std::string crm;
    std::cout << "CRM do médico a ser excluído: ";
    std::cin >> crm;
    for (size_t i = 0; i < medicos.size(); i++) {
        if (medicos[i].crm == crm) {
            medicos.erase(medicos.begin() + i);
            std::cout << "Médico excluído com sucesso!" << std::endl;
            return;
        }
    }
    std::cout << "Médico não encontrado." << std::endl;
}

void listarMedicos(const std::vector<Medico>& medicos) {
    std::cout << "Lista de médicos:" << std::endl;
    for (const Medico& medico : medicos) {
        std::cout << "Nome: " << medico.nome << " | CRM: " << medico.crm << std::endl;
    }
}
