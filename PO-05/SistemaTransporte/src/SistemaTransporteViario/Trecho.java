package SistemaTransporteViario;

public class Trecho {
    private PontoDeParada origem;
    private PontoDeParada destino;
    private int intervaloEstimado;

    public Trecho(PontoDeParada origem, PontoDeParada destino, int intervaloEstimado) {
        this.origem = origem;
        this.destino = destino;
        this.intervaloEstimado = intervaloEstimado;
    }

    public PontoDeParada getOrigem() {
        return origem;
    }

    public PontoDeParada getDestino() {
        return destino;
    }

    public int getIntervaloEstimado() {
        return intervaloEstimado;
    }
}
