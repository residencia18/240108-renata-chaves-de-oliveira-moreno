package TransporteEmpresa;

import java.time.LocalDateTime;

public class Checkpoints {
	    private int id;
	    private PontodeParada pontoDeParada;
	    private LocalDateTime horaChegada;
	    private Trechos trechos;
	    
	    @SuppressWarnings("rawtypes")
		private Trajetos trajetos;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public PontodeParada getPontoDeParada() {
			return pontoDeParada;
		}

		public void setPontoDeParada(PontodeParada pontoDeParada) {
			this.pontoDeParada = pontoDeParada;
		}

		public Trechos getTrechos() {
			return trechos;
		}

		public void setTrechos(Trechos trechos) {
			this.trechos = trechos;
		}

		public LocalDateTime getHoraChegada() {
			return horaChegada;
		}

		public void setHoraChegada(LocalDateTime horaChegada) {
			this.horaChegada = horaChegada;
		}

		@SuppressWarnings("rawtypes")
		public Trajetos getTrajetos() {
			return trajetos;
		}

		public void setTrajetos(@SuppressWarnings("rawtypes") Trajetos trajetos) {
			this.trajetos = trajetos;
		}


}
