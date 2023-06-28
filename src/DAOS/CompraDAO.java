package DAOS;

import java.util.List;

import Exceptions.CompraException;
import Classes.Compra;

public interface CompraDAO {

    public void cadastrar(Compra compra) throws CompraException;

    public List<Compra> listar();

    public void remover(Integer codigo) throws CompraException;

    public Compra buscarPorCodigo(Integer codigo);

    public void atualizar(Compra compra) throws CompraException;
}