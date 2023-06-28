package DAOS;

import DAOS.implement.*;

public class DAOFactory {

    public static CartaoDAO getCartaoDAO() {
        return new CartaoDAOimplem();
    }

    public static CategoriaDAO getCategoriaDAO() {
        return new CategoriaDAOimplem();
    }

    public static CelularDAO getCelularDAO() {
        return new CelularDAOimplem();
    }

    public static CompraDAO getCompraDAO() {
        return new CompraDAOimplem();
    }

    public static ContaDAO getContaDAO() {
        return new ContaDAOimplem();
    }

    public static GastoDAO getGastoDAO() {
        return new GastoDAOimplem();
    }

    public static LancamentoDAO getLancamentoDAO() {
        return new LancamentoDAOimplem();
    }

    public static NomeDAO getNomeDAO() {
        return new NomeDAOimplem();
    }

    public static ParcelamentoDAO getParcelamentoDAO() {
        return new ParcelamentoDAOimplem();
    }

    public static RecebimentoDAO getRecebimentoDAO() {
        return new RecebimentoDAOimplem();
    }

    public static TipoContaDAO getTipoContaDAO() {
        return new TipoContaDAOimplem();
    }

    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOimplem();
    }
}
