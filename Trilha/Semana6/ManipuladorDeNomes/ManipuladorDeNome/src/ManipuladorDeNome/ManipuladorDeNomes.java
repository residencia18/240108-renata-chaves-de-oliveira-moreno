
package ManipuladorDeNome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManipuladorDeNomes {

    private String[] nomes;

    public ManipuladorDeNomes(String[] nomes) {
        this.nomes = nomes;
    }

        public boolean verificarNomeNoArray(String nome) {
        for (String nomeAtual : nomes) {
            if (nomeAtual.equals(nome)) {
                return true;
            }
        }
        return false;
    }

      public boolean verificarNomeNaLista(String nome) {
        List<String> listaDeNomes = Arrays.asList(nomes);
        return listaDeNomes.contains(nome);
    }

   
    public void modificarNomeNoArray(String nomeAntigo, String novoNome) throws NomeNaoEncontradoException {
        boolean nomeEncontrado = false;

        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals(nomeAntigo)) {
                nomes[i] = novoNome;
                nomeEncontrado = true;
                break;
            }
        }

        if (!nomeEncontrado) {
            throw new NomeNaoEncontradoException("Nome não encontrado no array.");
        }
    }

    
    public void modificarNomeNaLista(String nomeAntigo, String novoNome) throws NomeNaoEncontradoException {
        List<String> listaDeNomes = new ArrayList<>(Arrays.asList(nomes));

        if (listaDeNomes.contains(nomeAntigo)) {
            int indice = listaDeNomes.indexOf(nomeAntigo);
            listaDeNomes.set(indice, novoNome);
            nomes = listaDeNomes.toArray(new String[0]);
        } else {
            throw new NomeNaoEncontradoException("Nome não encontrado na lista.");
        }
    }

    public static void main(String[] args) {
        String[] arrayDeNomes = {"Renata", "Samuel", "Charlie", "Gabriel"};
        ManipuladorDeNomes manipulador = new ManipuladorDeNomes(arrayDeNomes);

       
        System.out.println(manipulador.verificarNomeNoArray("Samuel"));  

       
        System.out.println(manipulador.verificarNomeNaLista("Gabriel"));  

       
        try {
            manipulador.modificarNomeNoArray("Charlie", "Bela");
            System.out.println(Arrays.toString(manipulador.nomes)); 
        } catch (NomeNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

       
        try {
            manipulador.modificarNomeNaLista("Renata", "Sofia");
            System.out.println(Arrays.toString(manipulador.nomes));  
        } catch (NomeNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}


class NomeNaoEncontradoException extends Exception {
    public NomeNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
