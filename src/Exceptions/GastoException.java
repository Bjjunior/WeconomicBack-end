package Exceptions;

public class GastoException extends Exception {
    public GastoException(String message) {
        super(message);
    }

    public GastoException(String message, Throwable cause) {
        super(message, cause);
    }
}
