package TransporteEmpresa;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("hiding")
public class Trajetos<Veiculo> {
	    private int id;
	    private List<Trechos> trechos = new ArrayList<>();
	    private List<Checkpoints> checkpoints = new ArrayList<>();
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Veiculo getVeiculo() {
			return getVeiculo();
		}
		public void setVeiculo(Veiculo veiculo) {
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
		public String getNome() {
			return getNome();
		}
		public void setNome(String nome) {
		}
	
	
}
