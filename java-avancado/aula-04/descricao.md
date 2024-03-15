# Teste de APIs REST

Agora colocaremos essas APIs REST nos controladores de funcionários e projetos para teste.

## Funcionários

- **Criar funcionário:**
  - Endpoint: [POST /api/employee/createEmployee](http://localhost:8081/api/employee/createEmployee)
  - Descrição: Cria um novo funcionário no sistema.

- **Criar funcionário para o Projeto:**
  - Endpoint: [POST /api/employee/createEmployeeForProject/{projectId}](http://localhost:8081/api/employee/createEmployeeForProject/3)
  - Descrição: Cria um novo funcionário e o associa a um projeto existente.

- **Atribuir funcionário a um projeto:**
  - Endpoint: [POST /api/employee/assignEmployeeToProject/{projectId}](http://localhost:8081/api/employee/assignEmployeeToProject/2)
  - Descrição: Atribui um funcionário a um projeto existente.

- **Obter detalhes do funcionário:**
  - Endpoint: [GET /api/employee/getEmployee/{employeeId}](http://localhost:8081/api/employee/getEmployee/2)
  - Descrição: Retorna os detalhes de um funcionário com o ID especificado.

## Projetos

- **Criar projeto:**
  - Endpoint: [POST /api/project/createProject](http://localhost:8081/api/project/createProject)
  - Descrição: Cria um novo projeto no sistema.

- **Criar um projeto para funcionários:**
  - Endpoint: [POST /api/project/createProjectForEmployees](http://localhost:8081/api/project/createProjectForEmployees)
  - Descrição: Cria um novo projeto e associa alguns funcionários existentes a ele.

- **Obter detalhes do projeto:**
  - Endpoint: [GET /api/project/getProject/{projectId}](http://localhost:8081/api/project/getProject/3)
  - Descrição: Retorna os detalhes de um projeto com o ID especificado.
