package TransporteEmpresa;

import java.util.ArrayList;
import java.util.List;

public class Passageiros {
	
	private int id;
	private String nome;
	private String cpf;
	private String tipoCartao;
	
	@SuppressWarnings("unused")
	
	private List<RegistroEmbarque> registroEmbarque = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoCartao() {
		return tipoCartao;
	}
	public void setTipoCartao(String tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

}
