package SistemaTransporteViario;

import java.util.Date;

public class Jornada {
    private Motorista motorista;
    private Cobrador cobrador;
    private Veiculo veiculo;
    private Trajeto trajeto;
    private Date inicio;
    private Date fim;

    public Jornada(Motorista motorista, Cobrador cobrador, Veiculo veiculo, Trajeto trajeto, Date inicio, Date fim) {
        this.motorista = motorista;
        this.cobrador = cobrador;
        this.veiculo = veiculo;
        this.trajeto = trajeto;
        this.inicio = inicio;
        this.fim = fim;
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
}
