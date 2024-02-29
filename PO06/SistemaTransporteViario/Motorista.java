package SistemaTransporteViario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Motorista {
    private String nome;
    private String numeroCNH;

    public Motorista(String nome, String numeroCNH) {
        this.nome = nome;
        this.numeroCNH = numeroCNH;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void salvarMotorista() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("motoristas.csv", true))) {
            writer.println(nome + "," + numeroCNH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Motorista> carregarMotoristas() {
        List<Motorista> motoristas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("motoristas.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    Motorista motorista = new Motorista(partes[0], partes[1]);
                    motoristas.add(motorista);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return motoristas;
    }
}
