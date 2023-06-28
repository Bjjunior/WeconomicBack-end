package Exceptions;

public class ParcelamentoException extends Exception {

    public ParcelamentoException(String mensagem) {
        super(mensagem);
    }

    public ParcelamentoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}