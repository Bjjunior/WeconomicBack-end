package DAOS;

import java.util.List;

import Exceptions.CategoriaException;
import Classes.Categoria;

public interface CategoriaDAO {

    public void cadastrar(Categoria categoria) throws CategoriaException;

    public List<Categoria> listar() throws CategoriaException;

    public void remover(Integer codigo) throws CategoriaException;

    public Categoria buscarPorCodigo(Integer codigo) throws CategoriaException;

    public void atualizar(Categoria categoria) throws CategoriaException;
}