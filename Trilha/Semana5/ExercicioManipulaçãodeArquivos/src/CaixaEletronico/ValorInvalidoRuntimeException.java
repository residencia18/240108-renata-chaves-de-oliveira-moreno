// ValorInvalidoRuntimeException.java
package CaixaEletronico;

@SuppressWarnings("serial")
public class ValorInvalidoRuntimeException extends RuntimeException {
    public ValorInvalidoRuntimeException(String mensagem) {
        super(mensagem);
    }
}
