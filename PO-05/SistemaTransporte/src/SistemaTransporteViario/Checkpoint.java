package SistemaTransporteViario;

import java.util.Date;

public class Checkpoint {
    private Trajeto trajeto;
    private Date dataHora;

    public Checkpoint(Trajeto trajeto, Date dataHora) {
        this.trajeto = trajeto;
        this.dataHora = dataHora;
    }

    public Trajeto getTrajeto() {
        return trajeto;
    }

    public Date getDataHora() {
        return dataHora;
    }
}
