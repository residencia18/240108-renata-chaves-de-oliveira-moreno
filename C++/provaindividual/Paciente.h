#ifndef PACIENTE_H
#define PACIENTE_H

#include <string>
#include <vector>

class Paciente {
public:
    std::string nome;
    std::string cpf;
    std::string dataNascimento;

    Paciente(std::string _nome, std::string _cpf, std::string _dataNascimento);
};

void cadastrarPaciente(std::vector<Paciente>& pacientes);
void excluirPaciente(std::vector<Paciente>& pacientes);
void listarPacientes(const std::vector<Paciente>& pacientes);

#endif
