package TransporteEmpresa;

public class Veiculo {
	private int id;
	private String placa;
	private String modelo;
	private int capacidade;
	private Motorista motorista;
	private Cobrador cobrador;
	private Trajetos<?> trajeto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public Cobrador getCobrador() {
		return cobrador;
	}
	public void setCobrador(Cobrador cobrador) {
		this.cobrador = cobrador;
	}
	@SuppressWarnings("rawtypes")
	
	public Trajetos getTrajeto() {
		return trajeto;
	}
	public void setTrajeto(@SuppressWarnings("rawtypes") Trajetos trajeto) {
		this.trajeto = trajeto;
	}
	
}