
package DAOS;

import java.util.List;

import Classes.TipoConta;

public interface TipoContaDAO {

    public void cadastrar(TipoConta tipoConta);

    public List<TipoConta> listar();

    public void remover(Integer codgo);

    public TipoConta buscarPorCd(Integer codigo);

    public void atualizar(TipoConta tipoConta);
}