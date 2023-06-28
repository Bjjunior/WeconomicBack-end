package DAOS;

import java.util.List;

import Exceptions.CelularException;
import Classes.Celular;

public interface CelularDAO {

    public void cadastrar(Celular celular) throws CelularException;

    public List<Celular> listar() throws CelularException;

    public void remover(Integer codigo) throws CelularException;

    public Celular buscarPorCodigo(Integer codigo) throws CelularException;

    public void atualizar(Celular celular) throws CelularException;
}