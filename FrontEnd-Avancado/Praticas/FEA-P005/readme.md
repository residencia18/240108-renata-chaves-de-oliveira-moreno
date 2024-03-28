# Aplicação de Manejo Sanitário de Animais

Esta aplicação permite o gerenciamento de sessões de manejo sanitário para animais de uma fazenda. O manejo sanitário consiste em um conjunto de atividades regularmente planejadas e direcionadas para a prevenção e manutenção da saúde dos animais.

## Funcionalidades

- Cadastro de sessões de manejo sanitário, incluindo data, descrição, animais participantes e atividades planejadas.
- Adição e remoção dinâmica de vacinas para cada sessão.
- Exibição das sessões cadastradas.

## Estrutura Adicionada ao Projeto

- **src/app/components/manejo-sanitario/**: Contém o componente Angular responsável pela funcionalidade de manejo sanitário.
  - **manejo-sanitario.component.ts**: Lógica do componente.
  - **manejo-sanitario.component.html**: Template HTML do componente.
  - **manejo-sanitario.component.css**: Estilos CSS do componente.
- **src/app/services/**: Contém serviços utilizados pela aplicação.
  - **manejo.service.ts**: Serviço para interação com o backend para salvar sessões de manejo sanitário.

