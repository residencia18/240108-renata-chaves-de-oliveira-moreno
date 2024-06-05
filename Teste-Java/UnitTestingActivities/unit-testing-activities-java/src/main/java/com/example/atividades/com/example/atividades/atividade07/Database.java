package com.example.atividades.atividade07;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class Database {
    private List<User> users = new ArrayList<>();

    public Database(FakeDatabase fakeDatabase) {
        // TODO: Implementar a lógica conforme necessário
    }

    public void saveUser(User user) {
        // Simula o salvamento do usuário no banco de dados
        users.add(user);
    }

    public List<User> getUsers() {
        // Retorna a lista de usuários
        return users;
    }
}
