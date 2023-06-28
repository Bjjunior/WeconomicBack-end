package DAOS;

import java.util.List;

import Classes.Lancamento;
import Exceptions.LancamentoException;

public interface LancamentoDAO {

    public void cadastrar(Lancamento lancamento) throws LancamentoException;

    public List<Lancamento> listar() throws LancamentoException;

    public void remover(Integer cd_lcto) throws LancamentoException;

    public void atualizar(Lancamento lancamento) throws LancamentoException;

    public Lancamento buscarPorCodigo(Integer cd_lcto) throws LancamentoException;
}