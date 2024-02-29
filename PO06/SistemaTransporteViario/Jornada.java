package SistemaTransporteViario;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jornada {
    private static long nextId = 1;

    private long id;
    private Motorista motorista;
    private Cobrador cobrador;
    private Veiculo veiculo;
    private Trajeto trajeto;
    private Date inicio;
    private Date fim;

    public Jornada(Motorista motorista, Cobrador cobrador, Veiculo veiculo, Trajeto trajeto, Date inicio, Date fim) {
        this.id = nextId++;
        this.motorista = motorista;
        this.cobrador = cobrador;
        this.veiculo = veiculo;
        this.trajeto = trajeto;
        this.inicio = inicio;
        this.fim = fim;
    }

    public long getId() {
        return id;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public Cobrador getCobrador() {
        return cobrador;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Trajeto getTrajeto() {
        return trajeto;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void salvarJornada() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("jornadas.csv", true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            writer.println(
                    id + "," +
                    motorista.getNome() + "," +
                    (cobrador != null ? cobrador.getNome() : "") + "," +
                    veiculo.getPlaca() + "," +
                    trajeto.toString() + "," +
                    sdf.format(inicio) + "," +
                    sdf.format(fim)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Jornada> carregarJornadas(List<Motorista> motoristas, List<Cobrador> cobradores, List<Veiculo> veiculos, List<Trajeto> trajetos) {
        List<Jornada> jornadas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("jornadas.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 7) {
                    long id = Long.parseLong(partes[0]);
                    Motorista motorista = encontrarMotoristaPorNome(motoristas, partes[1]);
                    Cobrador cobrador = null;
                    if (!partes[2].isEmpty()) {
                        cobrador = encontrarCobradorPorNome(cobradores, partes[2]);
                    }
                    Veiculo veiculo = encontrarVeiculoPorPlaca(veiculos, partes[3]);
                    Trajeto trajeto = encontrarTrajetoPorDescricao(trajetos, partes[4]);
                    Date inicio = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(partes[5]);
                    Date fim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(partes[6]);

                    if (motorista != null && veiculo != null && trajeto != null) {
                        Jornada jornada = new Jornada(motorista, cobrador, veiculo, trajeto, inicio, fim);
                        jornada.id = id; // Atribuição direta ao atributo público id
                        jornadas.add(jornada);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jornadas;
    }

    private static Motorista encontrarMotoristaPorNome(List<Motorista> motoristas, String nome) {
        for (Motorista motorista : motoristas) {
            if (motorista.getNome().equals(nome)) {
                return motorista;
            }
        }
        return null;
    }

    private static Cobrador encontrarCobradorPorNome(List<Cobrador> cobradores, String nome) {
        for (Cobrador cobrador : cobradores) {
            if (cobrador.getNome().equals(nome)) {
                return cobrador;
            }
        }
        return null;
    }

    private static Veiculo encontrarVeiculoPorPlaca(List<Veiculo> veiculos, String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
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
