package SistemaTransporteViario;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PassageiroEmbarque {
    private Passageiro passageiro;
    private String pontoEmbarque;
    private String numeroCartao;
    private Date dataHora;

    public PassageiroEmbarque(Passageiro passageiro, String pontoEmbarque, String numeroCartao, Date dataHora) {
        this.passageiro = passageiro;
        this.pontoEmbarque = pontoEmbarque;
        this.numeroCartao = numeroCartao;
        this.dataHora = dataHora;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public String getPontoEmbarque() {
        return pontoEmbarque;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void salvarPassageiroEmbarque() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("passageiros_embarque.csv", true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            writer.println(
                    passageiro.getNome() + "," +
                    pontoEmbarque + "," +
                    numeroCartao + "," +
                    sdf.format(dataHora)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PassageiroEmbarque> carregarPassageirosEmbarque(List<Passageiro> passageiros, List<PontoDeParada> pontosDeParada) {
        List<PassageiroEmbarque> passageirosEmbarque = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("passageiros_embarque.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 4) {
                    Passageiro passageiro = encontrarPassageiroPorNome(passageiros, partes[0]);
                    PontoDeParada pontoEmbarque = encontrarPontoDeParada(pontosDeParada, partes[1]);
                    String numeroCartao = partes[2];
                    Date dataHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(partes[3]);

                    if (passageiro != null && pontoEmbarque != null) {
                        PassageiroEmbarque passageiroEmbarqueObj = new PassageiroEmbarque(passageiro, pontoEmbarque.getNome(), numeroCartao, dataHora);
                        passageirosEmbarque.add(passageiroEmbarqueObj);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passageirosEmbarque;
    }

    private static Passageiro encontrarPassageiroPorNome(List<Passageiro> passageiros, String nome) {
        for (Passageiro passageiro : passageiros) {
            if (passageiro.getNome().equals(nome)) {
                return passageiro;
            }
        }
        return null;
    }

    private static PontoDeParada encontrarPontoDeParada(List<PontoDeParada> pontosDeParada, String nome) {
        for (PontoDeParada ponto : pontosDeParada) {
            if (ponto.getNome().equals(nome)) {
                return ponto;
            }
        }
        return null;
    }
}

