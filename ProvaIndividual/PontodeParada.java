package TransporteEmpresa;

import java.util.ArrayList;
import java.util.List;

public class PontodeParada {
		private int id;
		private String nome;
		private String localizacao;
		private List<Trechos> trechos = new ArrayList<>();
		private List<RegistroEmbarque> registrosEmbarque = new ArrayList<>();
		public List<RegistroEmbarque> getRegistrosEmbarque() {
			return registrosEmbarque;
		}
		public void setRegistrosEmbarque(List<RegistroEmbarque> registrosEmbarque) {
			this.registrosEmbarque = registrosEmbarque;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getLocalizacao() {
			return localizacao;
		}
		public void setLocalizacao(String localizacao) {
			this.localizacao = localizacao;
		}
		public List<Trechos> getTrechos() {
			return trechos;
		}
		public void setTrechos(List<Trechos> trechos) {
			this.trechos = trechos;
		}

}