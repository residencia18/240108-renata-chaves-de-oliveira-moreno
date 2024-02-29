package Estudante;

class Usuario {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuário: " + this.nome;
    }
}
