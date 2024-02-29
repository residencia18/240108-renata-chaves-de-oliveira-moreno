package SistemaTransporteViario;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Checkpoint {
    private static long nextId = 1;

    public long id;
    private Trajeto trajeto;
    private Date dataHora;

    public Checkpoint(Trajeto trajeto, Date dataHora) {
        this.id = nextId++;
        this.trajeto = trajeto;
        this.dataHora = dataHora;
    }

    public long getId() {
        return id;
    }

    public Trajeto getTrajeto() {
        return trajeto;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void salvarCheckpoint() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("checkpoints.csv", true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            writer.println(
                    id + "," +
                    trajeto.toString() + "," +
                    sdf.format(dataHora)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Checkpoint> carregarCheckpoints(List<Trajeto> trajetos) {
        List<Checkpoint> checkpoints = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("checkpoints.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    long id = Long.parseLong(partes[0]);
                    Trajeto trajeto = encontrarTrajetoPorDescricao(trajetos, partes[1]);
                    Date dataHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(partes[2]);

                    if (trajeto != null) {
                        Checkpoint checkpoint = new Checkpoint(trajeto, dataHora);
                        checkpoint.id = id; // Atribuição direta ao atributo público id
                        checkpoints.add(checkpoint);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkpoints;
    }

    private static Trajeto encontrarTrajetoPorDescricao(List<Trajeto> trajetos, String descricao) {
        for (Trajeto trajeto : trajetos) {
            if (trajeto.toString().equals(descricao)) {
                return trajeto;
            }
        }
        return null;
    }
}
