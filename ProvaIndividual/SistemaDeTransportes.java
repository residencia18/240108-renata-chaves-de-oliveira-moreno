package TransporteEmpresa;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeTransportes {
		private List<Veiculo> veiculos = new ArrayList<>();
	    private List<Motorista> motoristas = new ArrayList<>();
	    private List<Cobrador> cobradores = new ArrayList<>();
	    private List<Passageiros> passageiros = new ArrayList<>();
	    private List<PontodeParada> pontosDeParada = new ArrayList<>();
	    @SuppressWarnings("rawtypes")
		private List<Trajetos> trajetos = new ArrayList<>();
	    private List<Trechos> trechos = new ArrayList<>();
	    private List<Checkpoints> checkpoints = new ArrayList<>();
	    private List<Jornada> jornadas = new ArrayList<>();
	    private List<RegistroEmbarque> registrosEmbarque = new ArrayList<>();
		public List<Veiculo> getVeiculos() {
			return veiculos;
		}
		public void setVeiculos(List<Veiculo> veiculos) {
			this.veiculos = veiculos;
		}
		public List<Motorista> getMotoristas() {
			return motoristas;
		}
		public void setMotoristas(List<Motorista> motoristas) {
			this.motoristas = motoristas;
		}
		public List<Passageiros> getPassageiros() {
			return passageiros;
		}
		public void setPassageiros(List<Passageiros> passageiros) {
			this.passageiros = passageiros;
		}
		public List<Cobrador> getCobradores() {
			return cobradores;
		}
		public void setCobradores(List<Cobrador> cobradores) {
			this.cobradores = cobradores;
		}
		@SuppressWarnings("rawtypes")
		public List<Trajetos> getTrajetos() {
			return trajetos;
		}
		public void setTrajetos(@SuppressWarnings("rawtypes") List<Trajetos> trajetos) {
			this.trajetos = trajetos;
		}
		public List<PontodeParada> getPontosDeParada() {
			return pontosDeParada;
		}
		public void setPontosDeParada(List<PontodeParada> pontosDeParada) {
			this.pontosDeParada = pontosDeParada;
		}
		public List<Trechos> getTrechos() {
			return trechos;
		}
		public void setTrechos(List<Trechos> trechos) {
			this.trechos = trechos;
		}
		public List<Checkpoints> getCheckpoints() {
			return checkpoints;
		}
		public void setCheckpoints(List<Checkpoints> checkpoints) {
			this.checkpoints = checkpoints;
		}
		public List<Jornada> getJornadas() {
			return jornadas;
		}
		public void setJornadas(List<Jornada> jornadas) {
			this.jornadas = jornadas;
		}
		public List<RegistroEmbarque> getRegistrosEmbarque() {
			return registrosEmbarque;
		}
		public void setRegistrosEmbarque(List<RegistroEmbarque> registrosEmbarque) {
			this.registrosEmbarque = registrosEmbarque;
		}


}
