package SistemadeLogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaLogin {
    private List<Usuario> listaUsuarios;

    public SistemaLogin() {
        this.listaUsuarios = new ArrayList<>();
    }

    public void cadastrarUsuario() throws CredenciaisInvalidasException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Cadastro de Usuário");
            System.out.print("Nome de Usuário: ");
            String username = scanner.nextLine();

            if (username.isEmpty()) {
                throw new CredenciaisInvalidasException("Nome de usuário não pode ser vazio.");
            }

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (senha.length() < 6) {
                throw new CredenciaisInvalidasException("Senha deve ter pelo menos 6 caracteres.");
            }

            Usuario novoUsuario = new Usuario(username, senha);
            listaUsuarios.add(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!");
        }
    }

    public void login() throws UsuarioErradoException, AutenticacaoFalhouException, UsuarioBloqueadoException {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

        System.out.println("Login");

        Usuario usuario = null;

        int tentativas = 0;
        while (tentativas < 3) {
            System.out.print("Nome de Usuário: ");
            String username;
            if (scanner.hasNextLine()) {
                username = scanner.nextLine();
            } else {
                throw new UsuarioErradoException("Nome de usuário não fornecido.");
            }

            usuario = listaUsuarios.stream()
                    .filter(u -> u.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);

            if (usuario != null) {
                break;  // Usuário encontrado, sair do loop
            } else {
                System.out.println("Usuário não encontrado. Tente novamente.");
            }

            tentativas++;
        }

        if (tentativas == 3) {
            throw new UsuarioBloqueadoException("Três tentativas de login falhas. Usuário bloqueado.");
        }

        // lógica para solicitar a senha apenas se o usuário foi encontrado
        System.out.print("Senha: ");
        String senha;
        if (scanner.hasNextLine()) {
            senha = scanner.nextLine();
        } else {
            throw new AutenticacaoFalhouException("Senha não fornecida.");
        }

        if (senha.length() < 6 || !usuario.getSenha().equals(senha)) {
            throw new AutenticacaoFalhouException("Autenticação falhou.");
        }

        System.out.println("Login bem-sucedido!");
    }

    public static void main(String[] args) {
        SistemaLogin sistemaLogin = new SistemaLogin();

        try {
            sistemaLogin.cadastrarUsuario();
            sistemaLogin.login();
        } catch (CredenciaisInvalidasException | UsuarioErradoException |
                AutenticacaoFalhouException | UsuarioBloqueadoException e) {
            e.printStackTrace();
        }
    }
}
