package energiaCoelho;

import java.util.Date;

public class Fatura {
    private Date dataEmissao;
    private double ultimaLeitura;
    private double penultimaLeitura;
    private double valorCalculado;
    private boolean quitado;

    public Fatura(double ultimaLeitura, double penultimaLeitura, Date dataEmissao) {
        this.ultimaLeitura = ultimaLeitura;
        this.penultimaLeitura = penultimaLeitura;
        this.dataEmissao = dataEmissao;
        this.quitado = false; // Inicialmente a fatura não está quitada
        this.valorCalculado = calcularValorCalculado(); // Calcula o valor da fatura
    }

    public Fatura(String cpfCliente, String enderecoImovel, double valor) {
		// TODO Auto-generated constructor stub
	}

	private double calcularValorCalculado() {
        // Implemente a lógica de cálculo do valor da fatura (exemplo: custo de 10 reais por KWh)
        return (ultimaLeitura - penultimaLeitura) * 10; // Exemplo de cálculo simples
    }

    // Getters e setters

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public double getUltimaLeitura() {
        return ultimaLeitura;
    }

    public void setUltimaLeitura(double ultimaLeitura) {
        this.ultimaLeitura = ultimaLeitura;
    }

    public double getPenultimaLeitura() {
        return penultimaLeitura;
    }

    public void setPenultimaLeitura(double penultimaLeitura) {
        this.penultimaLeitura = penultimaLeitura;
    }

    public double getValorCalculado() {
        return valorCalculado;
    }

    public boolean isQuitado() {
        return quitado;
    }

    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }

	public Object getCpfCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEnderecoImovel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setValor(double novoValor) {
		// TODO Auto-generated method stub
		
	}
}
