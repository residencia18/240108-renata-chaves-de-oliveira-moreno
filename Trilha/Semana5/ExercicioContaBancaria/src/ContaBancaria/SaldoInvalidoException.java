package ContaBancaria;

public class SaldoInvalidoException extends RuntimeException {

    public SaldoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
