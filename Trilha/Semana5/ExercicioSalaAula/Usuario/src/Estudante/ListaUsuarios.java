package Estudante;

import java.util.ArrayList;

public class ListaUsuarios {
    private ArrayList<Usuario> usuarios;

    public ListaUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
    
    public void listar(int x) {
        if (x >= 0 && x < this.usuarios.size()) {
            for (int i = x; i < this.usuarios.size(); i++) {
                System.out.println(this.usuarios.get(i));
            }
        } else {
            System.out.println("Posição inválida.");
        }
    }

   public void listar(int x, int y) {
        if (x >= 0 && y >= 0 && x < this.usuarios.size() && y < this.usuarios.size() && x <= y) {
            for (int i = x; i <= y; i++) {
                System.out.println(this.usuarios.get(i));
            }
        } else {
            System.out.println("Posições inválidas.");
        }
    }

    public static void main(String[] args) {
        ListaUsuarios lista = new ListaUsuarios();

       
        lista.adicionarUsuario(new Usuario("João"));
        lista.adicionarUsuario(new Usuario("Maria"));
        lista.adicionarUsuario(new Usuario("Carlos"));
        lista.adicionarUsuario(new Usuario("Ana"));

        System.out.println("Listar todos os usuários:");
        lista.listar(0);

        System.out.println("\nListar a partir da posição 2:");
        lista.listar(2);

        System.out.println("\nListar entre as posições 1 e 3:");
        lista.listar(1, 3);
    }
}



