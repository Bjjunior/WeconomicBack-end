package Exceptions;

public class tipoContaException extends Exception {

    public tipoContaException(String mensagem) {
        super(mensagem);
    }

    public tipoContaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}