package SistemadeLogin;

import java.io.Serializable;

public class CredenciaisInvalidasException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public CredenciaisInvalidasException(String message) {
        super(message);
    }
}
