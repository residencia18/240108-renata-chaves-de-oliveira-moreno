CREATE TABLE tarefa_funcionarios (
    tarefas_id INT,
    funcionarios_id INT,
    descricao TEXT,
    FOREIGN KEY (funcionarios_id) REFERENCES funcionario(id)
);
