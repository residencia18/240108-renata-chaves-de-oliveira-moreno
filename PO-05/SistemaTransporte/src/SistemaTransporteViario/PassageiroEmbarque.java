package SistemaTransporteViario;
import java.util.Date;


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
}
