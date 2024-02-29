package ContaBancaria;

public class ContaBancaria {

    private double saldo;
    private String titular; // Considerando o CPF como titular

    // Construtor que não permite instanciar uma conta sem titular e inicializa o saldo com 0
    public ContaBancaria(String titular) {
        if (titular == null || titular.isEmpty()) {
            throw new IllegalArgumentException("Titular não pode ser nulo ou vazio.");
        }
        this.titular = titular;
        this.saldo = 0;
    }

    // Método para depositar dinheiro na conta
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
        }
        this.saldo += valor;
    }

    // Método para sacar dinheiro da conta
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser maior que zero.");
        }
        if (valor > this.saldo) {
            throw new SaldoInvalidoException("Saldo insuficiente para realizar o saque.");
        }
        this.saldo -= valor;
    }

    // Método para verificar o saldo da conta
    public double verificarSaldo() {
        return this.saldo;
    }

    // Método para transferir dinheiro entre contas
    public void transferir(ContaBancaria contaDestino, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da transferência deve ser maior que zero.");
        }
        if (valor > this.saldo) {
            throw new SaldoInvalidoException("Saldo insuficiente para realizar a transferência.");
        }
        this.saldo -= valor;
        contaDestino.depositar(valor);
    }
}

