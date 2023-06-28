package DAOS;

import java.util.List;

import Classes.Recebimento;
import Exceptions.RecebimentoException;

public interface RecebimentoDAO {

    public void cadastrar(Recebimento recebimento) throws RecebimentoException;

    public List<Recebimento> listar() throws RecebimentoException;

    public void remover(Integer codigoLancamento) throws RecebimentoException;

    public Recebimento buscarPorCodigo(Integer codigoLancamento) throws RecebimentoException;

    public void atualizar(Recebimento recebimento) throws RecebimentoException;
}