package DAOS.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Classes.Conexao;
import DAOS.CartaoDAO;
import Exceptions.CartaoException;
import Classes.CartaoCredito;

public class CartaoDAOimplem implements CartaoDAO {

    private Connection conexao;

    public void cadastrar(CartaoCredito cartao) throws CartaoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO t_cartao_cr (cd_cartao, t_conta_cd_conta, t_parcelamento_cd_parcelamento, nm_cartao, dt_venc, dt_fechamento, vl_limite, cd_conta) VALUES (?,?,?,?,?,?,?,?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cartao.getCd_cartao());
            stmt.setInt(2, cartao.getTconta_cdconta());
            stmt.setInt(3, cartao.getCd_parcelamento());
            stmt.setString(4, cartao.getNm_cartao());
            stmt.setDate(5, cartao.getDt_venc());
            stmt.setDate(6, cartao.getDt_fechamento());
            stmt.setDouble(7, cartao.getVl_limite());
            stmt.setInt(8, cartao.getCd_conta());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new CartaoException("Erro ao cadastrar cartão.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new CartaoException("Erro ao fechar o statement.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CartaoException("Erro ao fechar a conexão.", e);
                }
            }
        }
    }

    public List<CartaoCredito> listar() throws CartaoException {

        List<CartaoCredito> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_cartao_cr");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer cdCartao = rs.getInt("cd_cartao");
                Integer tconta_cdconta = rs.getInt("t_conta_cd_conta");
                Integer cdParcelamento = rs.getInt("t_parcelamento_cd_parcelamento");
                String nmCartao = rs.getString("nm_cartao");
                Date dtVenc = rs.getDate("dt_venc");
                Date dtFechamento = rs.getDate("dt_fechamento");
                Double vlLimite = rs.getDouble("vl_limite");
                Integer cdConta = rs.getInt("cd_conta");

                CartaoCredito cartao = new CartaoCredito(cdCartao, tconta_cdconta, cdParcelamento, nmCartao, dtVenc,
                        dtFechamento, vlLimite, cdConta);
                lista.add(cartao);
            }
        } catch (SQLException e) {
            throw new CartaoException("Erro ao listar cartões.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new CartaoException("Erro ao fechar o statement ou o result set.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CartaoException("Erro ao fechar a conexão.", e);
                }
            }
        }
        return lista;
    }

    public void remover(Integer codigo) throws CartaoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM t_cartao_cr WHERE cd_cartao = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new CartaoException("Erro ao remover cartão.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new CartaoException("Erro ao fechar o statement.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CartaoException("Erro ao fechar a conexão.", e);
                }
            }
        }
    }

    public CartaoCredito buscarPorCodigo(Integer codigo) throws CartaoException {
        CartaoCredito cartao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_cartao_cr WHERE cd_cartao = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer cdCartao = rs.getInt("cd_cartao");
                Integer tconta_cdconta = rs.getInt("t_conta_cd_conta");
                Integer cdParcelamento = rs.getInt("t_parcelamento_cd_parcelamento");
                String nmCartao = rs.getString("nm_cartao");
                Date dtVenc = rs.getDate("dt_venc");
                Date dtFechamento = rs.getDate("dt_fechamento");
                Double vlLimite = rs.getDouble("vl_limite");
                Integer cdConta = rs.getInt("cd_conta");

                cartao = new CartaoCredito(cdCartao, tconta_cdconta, cdParcelamento, nmCartao, dtVenc, dtFechamento,
                        vlLimite, cdConta);
            }
        } catch (SQLException e) {
            throw new CartaoException("Erro ao buscar cartão.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new CartaoException("Erro ao fechar o statement ou o result set.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CartaoException("Erro ao fechar a conexão.", e);
                }
            }
        }
        return cartao;
    }

    public void atualizar(CartaoCredito cartao) throws CartaoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE t_cartao_cr SET t_conta_cd_conta = ?, t_parcelamento_cd_parcelamento = ?, nm_cartao = ?, dt_venc = ?, dt_fechamento = ?, vl_limite = ?, cd_conta = ? WHERE cd_cartao = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cartao.getTconta_cdconta());
            stmt.setInt(2, cartao.getCd_parcelamento());
            stmt.setString(3, cartao.getNm_cartao());
            stmt.setDate(4, cartao.getDt_venc());
            stmt.setDate(5, cartao.getDt_fechamento());
            stmt.setDouble(6, cartao.getVl_limite());
            stmt.setInt(7, cartao.getCd_conta());
            stmt.setInt(8, cartao.getCd_cartao());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new CartaoException("Erro ao atualizar cartão.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new CartaoException("Erro ao fechar o statement.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CartaoException("Erro ao fechar a conexão.", e);
                }
            }
        }
    }
}