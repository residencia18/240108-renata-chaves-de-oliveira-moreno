
INSERT INTO LEILAO (descricao, valor_minimo, status) VALUES ('Estatua Torre ', 250, 0);
INSERT INTO LEILAO (descricao, valor_minimo, status) VALUES ('Jogo Americano', 350, 0);
INSERT INTO LEILAO (descricao, valor_minimo, status) VALUES ('Monalisa', 2500000000, 0);

INSERT INTO CONCORRENTE (nome, cpf) VALUES ('Renata', '17623172645');
INSERT INTO CONCORRENTE (nome, cpf) VALUES ('Niviane', '17618772645');
INSERT INTO CONCORRENTE (nome, cpf) VALUES ('Degas', '17623382645');
INSERT INTO CONCORRENTE (CPF, NOME) VALUES ('Julio', '17644172641')

INSERT INTO LANCE (valor, Concorrente_Id, Leilao_Id) VALUES (350, 1, 1);
INSERT INTO LANCE (valor, Concorrente_Id, Leilao_Id) VALUES (450, 2, 2);
INSERT INTO LANCE (valor, Concorrente_Id, Leilao_Id) VALUES (550, 3, 3);