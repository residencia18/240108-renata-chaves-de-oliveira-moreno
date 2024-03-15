# Teste de APIs REST - Aula-04

Agora colocaremos essas APIs REST nos controladores de funcionários e projetos para teste.

## Criar funcionário
Para criar um novo funcionário, usaremos a seguinte URL no Postman:
- Endpoint: [http://localhost:8081/api/employee/createEmployee]
  http://localhost:8081/api/employee/createEmployee

## Criar projeto
Para criar um novo projeto, chamamos esta URL no Postman:
- Endpoint: [http://localhost:8081/api/project/createProject]
  http://localhost:8081/api/project/createProject

## Criar funcionário para o Projeto
Podemos criar um novo funcionário com essa solicitação e, em seguida, colocá-lo em um projeto existente. A seguir está a URL:
- Endpoint: [http://localhost:8081/api/employee/createEmployeeForProject/3]
  http://localhost:8081/api/employee/createEmployeeForProject/3

## Atribuir funcionário a um projeto
Recuperaremos as informações dos funcionários e do projeto com essa solicitação e, em seguida, atribuiremos esses funcionários a esse projeto. Passamos a id do projeto, valor 2, na URL, e as ids de funcionário são definidas no código:
- Endpoint: [http://localhost:8081/api/employee/assignEmployeeToProject/2]
  http://localhost:8081/api/employee/assignEmployeeToProject/2

## Obter detalhes do funcionário
Chamaremos essa URL para obter os detalhes do funcionário ao longo de seu projeto — Passamos o ID do funcionário (o valor é 2):
- Endpoint: [http://localhost:8081/api/employee/getEmployee/2]
  http://localhost:8081/api/employee/getEmployee/2

## Criar um projeto para funcionários
Usaremos essa API REST para criar um novo projeto e adicionar alguns funcionários existentes a ele:
- Endpoint: [http://localhost:8081/api/project/createProjectForEmployees]
  http://localhost:8081/api/project/createProjectForEmployees

## Obter detalhes do projeto
Usando essa API REST, agora recuperaremos um projeto existente, bem como suas informações de funcionário:
- Endpoint: [http://localhost:8081/api/project/getProject/3]
  http://localhost:8081/api/project/getProject/3
