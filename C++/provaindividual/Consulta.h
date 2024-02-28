#ifndef CONSULTA_H
#define CONSULTA_H

#include <string>
#include <vector>
#include "Paciente.h"
#include "Medico.h"

class Consulta {
public:
    Paciente* paciente;
    Medico* medico;
    std::string data;
    std::string hora;
    float duracao;
    std::string convenio;
    char realizada;

    Consulta(Paciente* _paciente, Medico* _medico);

    // Declare o construtor e métodos da classe aqui.
};

void gestaoConsultas(std::vector<Paciente>& pacientes, std::vector<Medico>& medicos, std::vector<Consulta>& consultas);
void cadastrarConsulta(std::vector<Paciente>& pacientes, std::vector<Medico>& medicos, std::vector<Consulta>& consultas);
void excluirConsulta(std::vector<Consulta>& consultas);
void alterarConsulta(std::vector<Consulta>& consultas);
void listarConsultas(const std::vector<Consulta>& consultas);

#endif
