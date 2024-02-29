package SistemaTransporteViario;

import java.util.Date;

public class RegistroInicioTrajeto {
    private Jornada jornada;
    private Date dataHora;

    public RegistroInicioTrajeto(Jornada jornada, Date dataHora) {
        this.jornada = jornada;
        this.dataHora = dataHora;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public Date getDataHora() {
        return dataHora;
    }
}
