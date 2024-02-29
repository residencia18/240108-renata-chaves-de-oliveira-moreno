package TransporteEmpresa;

import java.util.ArrayList;
import java.util.List;

public class Trechos {

	    private int id;
	    private PontodeParada pontoOrigem;
	    private PontodeParada pontoDestino;
	    private int intervaloEstimado;
	    @SuppressWarnings("rawtypes")
		private Trajetos trajeto;
	    private List<Checkpoints> checkpoints = new ArrayList<>();
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public PontodeParada getPontoOrigem() {
			return pontoOrigem;
		}
		public void setPontoOrigem(PontodeParada pontoOrigem) {
			this.pontoOrigem = pontoOrigem;
		}
		public PontodeParada getPontoDestino() {
			return pontoDestino;
		}
		public void setPontoDestino(PontodeParada pontoDestino) {
			this.pontoDestino = pontoDestino;
		}
		public int getIntervaloEstimado() {
			return intervaloEstimado;
		}
		public void setIntervaloEstimado(int intervaloEstimado) {
			this.intervaloEstimado = intervaloEstimado;
		}
		public Trajetos<?> getTrajeto() {
			return trajeto;
		}
		public void setTrajeto(Trajetos<?> trajeto) {
			this.trajeto = trajeto;
		}
		public List<Checkpoints> getCheckpoints() {
			return checkpoints;
		}
		public void setCheckpoints(List<Checkpoints> checkpoints) {
			this.checkpoints = checkpoints;
		}

}
