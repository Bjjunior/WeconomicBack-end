package Exceptions;

public class NomeException extends Exception {

    public NomeException(String mensagem) {
        super(mensagem);
    }

    public NomeException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}