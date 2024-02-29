package energiaCoelho;


public class Imovel {
    private String endereco;
    private double ultimaLeitura;
    private double penultimaLeitura;

    public Imovel(String endereco, double ultimaLeitura, double penultimaLeitura) {
        this.endereco = endereco;
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
    }
    
    public void atualizarLeituras() {
        this.penultimaLeitura = this.ultimaLeitura;
        // Lógica para obter a última leitura atualizada, por exemplo, pedir a entrada do usuário
        System.out.print("Informe a nova leitura atual do imóvel: ");
        Scanner scanner = new Scanner(System.in);
        this.ultimaLeitura = scanner.nextDouble();
    }


    public Imovel(String endereco2) {
		// TODO Auto-generated constructor stub
	}

	public String getEndereco() {
        return endereco;
    }

    public double getUltimaLeitura() {
        return ultimaLeitura;
    }

    public double getPenultimaLeitura() {
        return penultimaLeitura;
    }

    public void setEndereco(String novoEndereco) {
        this.endereco = novoEndereco;
    }

    @Override
    public String toString() {
        return "Imovel [endereco=" + endereco + ", ultimaLeitura=" + ultimaLeitura + ", penultimaLeitura="
                + penultimaLeitura + "]";
    }
}
