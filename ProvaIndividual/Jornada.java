package TransporteEmpresa;

import java.util.ArrayList;
import java.util.List;

public class Jornada {
    private int id;
    private Motorista motorista;
    private Veiculo veiculo;
    
    @SuppressWarnings("rawtypes")
    
	private List<Trajetos> trajetos = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	@SuppressWarnings("rawtypes")
	public List<Trajetos> getTrajetos() {
		return trajetos;
	}
	public void setTrajetos(@SuppressWarnings("rawtypes") List<Trajetos> trajetos) {
		this.trajetos = trajetos;
	}

    
}
