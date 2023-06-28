package DAOS;

import java.util.List;

import Classes.Gasto;
import Exceptions.GastoException;

public interface GastoDAO {

    public void cadastrar(Gasto gasto) throws GastoException;

    public List<Gasto> listar() throws GastoException;

    public void remover(Integer codigo) throws GastoException;

    public Gasto buscarPorId(Integer codigo) throws GastoException;

    public void atualizar(Gasto gasto) throws GastoException;
}