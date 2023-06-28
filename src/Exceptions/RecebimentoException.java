package Exceptions;

public class RecebimentoException extends Exception {

    public RecebimentoException(String mensagem) {
        super(mensagem);
    }

    public RecebimentoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
