package cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private String nome, email;
	private static String nacionalidade;
	private ArrayList<String> postagens;{
		this.nome = nome;
		this.email = email;
		this.nacionalidade = nacionalidade;
		this.listaDeEmails = new ArrayList<>();
		this.postagens = new ArrayList<String>();
		
}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	 public ArrayList<String> getListaDeEmails() {
	        return listaDeEmails;
	    }
	 
	 public ArrayList<String> getPostagens() {
	        return postagens;
	    }
	
	public void setPostagens(ArrayList<String> postagens) {
		this.postagens = postagens;
}
	public void adicionaPostagem(String post) {
        postagens.add(post);
    }
	 
	public class Main {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

	        String sn;
			do {
	            Usuario usuario = new Usuario();

	            System.out.print("Digite o nome do usuário: ");
	            usuario.setNome(scanner.nextLine());

	            System.out.print("Digite o email do usuário: ");
	            usuario.setEmail(scanner.nextLine());

	            System.out.print("Digite a nacionalidade do usuário: ");
	            usuario.setNacionalidade(scanner.nextLine());

	            listaUsuarios.add(usuario);

	            System.out.print("Deseja inserir mais usuários? (s/n): ");
	            String sn = scanner.nextLine();

	        } while (!sn.equalsIgnoreCase("n"));

	        
	        Usuario primeiroUsuario = listaUsuarios.get(0);
	        System.out.print("Digite uma postagem para o usuário " + primeiroUsuario.getNome() + ": ");
	        String postagem = scanner.nextLine();
	        primeiroUsuario.adicionaPostagem(postagem);

	        
	        System.out.print("Digite um valor para alterar a pontuação do usuário " + primeiroUsuario.getNome() + ": ");
	        int delta = scanner.nextInt();
	        primeiroUsuario.alteraPontuacao(delta);

	        System.out.println("\nInformações do primeiro usuário:");
	        System.out.println("Nome: " + primeiroUsuario.getNome());
	        System.out.println("Email: " + primeiroUsuario.getEmail());
	        System.out.println("Nacionalidade: " + primeiroUsuario.getNacionalidade());
	        System.out.println("Quantidade de postagens: " + primeiroUsuario.getQuantidadeDePostagens());
	        System.out.println("Pontuação: " + primeiroUsuario.getPontuacao());

	        scanner.close();
	    }
	}

	public String getPontuacao() {
		// TODO Auto-generated method stub
		return null;
	}
}

	

