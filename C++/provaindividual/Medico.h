#ifndef MEDICO_H
#define MEDICO_H

#include <string>
#include <vector>

class Medico {
public:
    std::string nome;
    std::string crm;

    Medico(std::string _nome, std::string _crm);
};

void cadastrarMedico(std::vector<Medico>& medicos);
void excluirMedico(std::vector<Medico>& medicos);
void listarMedicos(const std::vector<Medico>& medicos);

#endif
