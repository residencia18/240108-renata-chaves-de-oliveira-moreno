-- Inserir funcionários
INSERT INTO funcionario (nome, email, senha, cargo) VALUES ('Renata', 'renatachom.ad@gmail.com', 'senha123');
INSERT INTO funcionario (nome, email, senha, cargo) VALUES ('Maria', 'maria@example.com', 'senha456');
INSERT INTO funcionario (nome, email, senha, cargo) VALUES ('Samuel', 'samu@example.com', 'senha789');
INSERT INTO funcionario (nome, email, senha, cargo) VALUES ('Ana', 'ana@example.com', 'senhaabc');
INSERT INTO funcionario (nome, email, senha, cargo) VALUES ('Gabriel', 'biel@example.com', 'senhaxyz');

-- Inserir tarefas
INSERT INTO tarefa (titulo, descricao, prioridade, data_inicio, data_conclusao, status, funcionario_id) 
VALUES 
('Tarefa 1', 'Revisar Atividades Java', 1, '2024-04-20', '2024-04-25', 'PENDENTE', 1),
('Tarefa 2', 'Descrição da Tarefa 2', 2, '2024-04-21', '2024-04-26', 'CONCLUÍDA', 2),
('Tarefa 3', 'Estudar para teste Português', 3, '2024-04-22', '2024-04-27', 'PENDENTE', 3),
('Tarefa 4', 'Descrição da Tarefa 4', 2, '2024-04-23', '2024-04-28', 'CONCLUÍDA', 4),
('Tarefa 5', 'Fazer tarefas', 1, '2024-04-24', '2024-04-29', 'PENDENTE', 5);
