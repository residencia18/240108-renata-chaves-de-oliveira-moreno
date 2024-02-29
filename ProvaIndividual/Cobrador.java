package TransporteEmpresa;

public class Cobrador {
	private int id;
	private String nome;
	private String cpf;
	private String cnh;
	private Cobrador cobrador;
	
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
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Cobrador getCobrador() {
		return cobrador;
	}
	public void setCobrador(Cobrador cobrador) {
		this.cobrador = cobrador;
	}

}
