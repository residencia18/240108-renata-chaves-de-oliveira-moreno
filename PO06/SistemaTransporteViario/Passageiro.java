package SistemaTransporteViario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Passageiro {
    private String nome;
    private String tipoCartao;

    public Passageiro(String nome, String tipoCartao) {
        this.nome = nome;
        this.tipoCartao = tipoCartao;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void salvarPassageiro() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("passageiros.csv", true))) {
            writer.println(nome + "," + tipoCartao);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Passageiro> carregarPassageiros() {
        List<Passageiro> passageiros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("passageiros.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    Passageiro passageiro = new Passageiro(partes[0], partes[1]);
                    passageiros.add(passageiro);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passageiros;
    }
}
