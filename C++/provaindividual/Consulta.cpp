#include "Consulta.h"
#include "Paciente.h"
#include "Medico.h"
#include <iostream>

Consulta::Consulta(Paciente* _paciente, Medico* _medico) : paciente(_paciente), medico(_medico), realizada('n') {}

void gestaoConsultas(std::vector<Paciente>& pacientes, std::vector<Medico>& medicos, std::vector<Consulta>& consultas) {
    int opcao;
    do {
        std::cout << "Menu de Gestão de Consultas:" << std::endl;
        std::cout << "1. Incluir consulta" << std::endl;
        std::cout << "2. Excluir consulta" << std::endl;
        std::cout << "3. Alterar consulta" << std::endl;
        std::cout << "4. Listar consultas" << std::endl;
        std::cout << "0. Sair" << std::endl;
        std::cout << "Escolha a opção: ";
        std::cin >> opcao;

        switch (opcao) {
            case 1:
                cadastrarConsulta(pacientes, medicos, consultas);
                break;
            case 2:
                excluirConsulta(consultas);
                break;
            case 3:
                alterarConsulta(consultas);
                break;
            case 4:
                listarConsultas(consultas);
                break;
            case 0:
                break;
            default:
                std::cout << "Opção inválida." << std::endl;
        }
    } while (opcao != 0);
}

void cadastrarConsulta(std::vector<Paciente>& pacientes, std::vector<Medico>& medicos, std::vector<Consulta>& consultas) {
    std::string cpfPaciente, crmMedico, data, hora, convenio;
    float duracao;

    std::cout << "CPF do paciente: ";
    std::cin >> cpfPaciente;

    bool pacienteEncontrado = false;
    for (const Paciente& paciente : pacientes) {
        if (paciente.cpf == cpfPaciente) {
            pacienteEncontrado = true;
            break;
        }
    }

    if (!pacienteEncontrado) {
        std::cout << "Paciente não encontrado." << std::endl;
        return;
    }

    std::cout << "CRM do médico: ";
    std::cin >> crmMedico;

    bool medicoEncontrado = false;
    for (const Medico& medico : medicos) {
        if (medico.crm == crmMedico) {
            medicoEncontrado = true;
            break;
        }
    }

    if (!medicoEncontrado) {
        std::cout << "Médico não encontrado." << std::endl;
        return;
    }

    std::cout << "Data da consulta (dd/mm/aaaa): ";
    std::cin >> data;
    std::cout << "Hora da consulta (hh:mm): ";
    std::cin >> hora;
    std::cout << "Duração da consulta (em horas): ";
    std::cin >> duracao;
    std::cout << "Convênio: ";
    std::cin >> convenio;

    consultas.push_back(Consulta(&pacientes[0], &medicos[0]));
    consultas.back().data = data;
    consultas.back().hora = hora;
    consultas.back().duracao = duracao;
    consultas.back().convenio = convenio;

    std::cout << "Consulta cadastrada com sucesso!" << std::endl;
}

void excluirConsulta(std::vector<Consulta>& consultas) {
    std::string crmMedico;
    std::cout << "CRM do médico para exclusão de consulta: ";
    std::cin >> crmMedico;

    for (size_t i = 0; i < consultas.size(); i++) {
        if (consultas[i].medico->crm == crmMedico) {
            std::cout << "Paciente: " << consultas[i].paciente->nome << " | Data: " << consultas[i].data << " | Hora: " << consultas[i].hora << std::endl;
            std::cout << "Deseja excluir esta consulta (S/N)? ";
            char resposta;
            std::cin >> resposta;
            if (resposta == 'S' || resposta == 's') {
                consultas.erase(consultas.begin() + i);
                std::cout << "Consulta excluída com sucesso!" << std::endl;
                return;
            }
        }
    }
    std::cout << "Nenhuma consulta encontrada para o médico com CRM " << crmMedico << "." << std::endl;
}

void alterarConsulta(std::vector<Consulta>& consultas) {
    std::string crmMedico;
    std::cout << "CRM do médico para alteração de consulta: ";
    std::cin >> crmMedico;

    for (size_t i = 0; i < consultas.size(); i++) {
        if (consultas[i].medico->crm == crmMedico) {
            std::cout << "Paciente: " << consultas[i].paciente->nome << " | Data: " << consultas[i].data << " | Hora: " << consultas[i].hora << std::endl;
            std::cout << "Deseja marcar esta consulta como realizada (S/N)? ";
            char resposta;
            std::cin >> resposta;
            if (resposta == 'S' || resposta == 's') {
                consultas[i].realizada = 's';
                std::cout << "Consulta marcada como realizada." << std::endl;
                return;
            } else {
                std::cout << "Deseja alterar a data (S/N)? ";
                std::cin >> resposta;
                if (resposta == 'S' || resposta == 's') {
                    std::cout << "Nova data (dd/mm/aaaa): ";
                    std::cin >> consultas[i].data;
                }
                std::cout << "Deseja alterar a hora (S/N)? ";
                std::cin >> resposta;
                if (resposta == 'S' || resposta == 's') {
                    std::cout << "Nova hora (hh:mm): ";
                    std::cin >> consultas[i].hora;
                }
                std::cout << "Deseja alterar a duração (S/N)? ";
                std::cin >> resposta;
                if (resposta == 'S' || resposta == 's') {
                    std::cout << "Nova duração (em horas): ";
                    std::cin >> consultas[i].duracao;
                }
                std::cout << "Deseja alterar o convênio (S/N)? ";
                std::cin >> resposta;
                if (resposta == 'S' || resposta == 's') {
                    std::cout << "Novo convênio: ";
                    std::cin >> consultas[i].convenio;
                }
                std::cout << "Alterações realizadas com sucesso!" << std::endl;
                return;
            }
        }
    }
    std::cout << "Nenhuma consulta encontrada para o médico com CRM " << crmMedico << "." << std::endl;
}

void listarConsultas(const std::vector<Consulta>& consultas) {
    std::cout << "Lista de consultas:" << std::endl;
    for (const Consulta& consulta : consultas) {
        std::string realizada = (consulta.realizada == 's') ? "Realizada" : "Não Realizada";
        std::cout << "Paciente: " << consulta.paciente->nome << " | Médico: " << consulta.medico->nome
                  << " | Data: " << consulta.data << " | Hora: " << consulta.hora
                  << " | Duração: " << consulta.duracao << " horas | Convênio: " << consulta.convenio
                  << " | Status: " << realizada << std::endl;
    }
}
