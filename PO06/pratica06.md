# Sistema de Transporte Viário com Persistência de Dados

## Resumo

### Descrição do Projeto

Este projeto é um sistema de transporte viário que gerencia veículos, motoristas, cobradores, passageiros, pontos de parada, trajetos e jornadas. A novidade é a implementação de persistência de dados, onde todas as operações de inserção, atualização e exclusão são refletidas em arquivos para garantir a retenção de informações entre execuções.

### Persistência de Dados

- Toda vez que um novo dado é inserido, o programa salva o novo dado no arquivo correspondente.
- Toda vez que algum dado é alterado, o arquivo é modificado para persistir essa alteração.
- Toda vez que algum dado é excluído, o arquivo é modificado para persistir essa alteração.
- Quando o programa inicia, todos os dados dos arquivos são lidos e trazidos para a memória.

  
### Estrutura de Classes

- **Veiculo:**
  - Representa um veículo com placa e modelo.

- **Trecho:**
  - Liga dois pontos de parada, com um intervalo estimado.

- **Trajeto:**
  - Consiste em uma lista de trechos.

- **PontoDeParada:**
  - Representa um ponto de parada.

- **Jornada:**
  - Intervalo de tempo entre o início e o fim de um trajeto.

- **Motorista:**
  - Representa um motorista com nome e número de CNH.

- **Cobrador:**
  - Representa um cobrador com nome.

- **Passageiro:**
  - Representa um passageiro com nome e tipo de cartão.

- **PassageiroEmbarque:**
  - Registra o embarque de um passageiro em um ponto de parada.

- **SistemaTransporte:**
  - Classe principal que contém o método `main`.

- **RegistroInicioTrajeto:**
  - Registra o início de um trajeto.

- **Checkpoint:**
  - Registra a passagem por um checkpoint em um trajeto.

