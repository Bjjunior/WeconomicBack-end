package DAOS;

import java.util.List;

import Exceptions.CartaoException;
import Classes.CartaoCredito;

public interface CartaoDAO {

    public void cadastrar(CartaoCredito cartao) throws CartaoException;

    public List<CartaoCredito> listar() throws CartaoException;

    public void remover(Integer codigo) throws CartaoException;

    public CartaoCredito buscarPorCodigo(Integer codigo) throws CartaoException;

    public void atualizar(CartaoCredito cartao) throws CartaoException;
}