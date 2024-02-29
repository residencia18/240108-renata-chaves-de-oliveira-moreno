package SistemaTransporteViario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PontoDeParada {
    private String nome;

    public PontoDeParada(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void salvarPontoDeParada() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("pontos_de_parada.csv", true))) {
            writer.println(nome);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PontoDeParada> carregarPontosDeParada() {
        List<PontoDeParada> pontosDeParada = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("pontos_de_parada.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                PontoDeParada pontoDeParada = new PontoDeParada(linha);
                pontosDeParada.add(pontoDeParada);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pontosDeParada;
    }
}
