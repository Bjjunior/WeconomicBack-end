package DAOS;

import java.util.List;

import Classes.Nome;
import Exceptions.NomeException;

public interface NomeDAO {

    public void cadastrar(Nome nome) throws NomeException;

    public List<Nome> listar() throws NomeException;

    public void remover(Integer codigo) throws NomeException;

    public Nome buscarPorCodigo(Integer codigo) throws NomeException;

    public void atualizar(Nome nome) throws NomeException;
}
