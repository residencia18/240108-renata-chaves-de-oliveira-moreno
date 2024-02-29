package SistemadeLogin;

import java.io.Serializable;

public class AutenticacaoFalhouException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public AutenticacaoFalhouException(String message) {
        super(message);
    }
}
