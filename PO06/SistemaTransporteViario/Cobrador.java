package SistemaTransporteViario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cobrador {
    private String nome;

    public Cobrador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void salvarCobrador() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("cobradores.csv", true))) {
            writer.println(nome);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Cobrador> carregarCobradores() {
        List<Cobrador> cobradores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("cobradores.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Cobrador cobrador = new Cobrador(linha);
                cobradores.add(cobrador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cobradores;
    }
}
