package DAOS;

import java.util.List;

import Classes.Conta;
import Exceptions.ContaException;

public interface ContaDAO {

    public void cadastrar(Conta conta) throws ContaException;

    public List<Conta> listar() throws ContaException;

    public void remover(Integer cd_conta) throws ContaException;

    public Conta buscarPorCd(Integer codigo) throws ContaException;

    public void atualizar(Conta conta) throws ContaException;
}
