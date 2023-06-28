package DAOS.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Conexao;
import Classes.Gasto;
import DAOS.GastoDAO;
import Exceptions.GastoException;

public class GastoDAOimplem implements GastoDAO {

    private Connection conexao;

    public void cadastrar(Gasto gasto) throws GastoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO T_GASTO (T_LANCAMENTO_CD_LANCAMENTO, DS_LOCAL) VALUES (?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, gasto.getT_lancamento_cd_lancamento());
            stmt.setString(2, gasto.getDs_local());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new GastoException("Erro ao cadastrar o gasto.", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new GastoException("Erro ao fechar a conexão.", e);
            }
        }
    }

    public List<Gasto> listar() throws GastoException {
        List<Gasto> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM T_GASTO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer t_lancamento_cd_lancamento = rs.getInt("T_LANCAMENTO_CD_LANCAMENTO");
                String ds_local = rs.getString("DS_LOCAL");

                Gasto gasto = new Gasto(t_lancamento_cd_lancamento, ds_local);
                lista.add(gasto);
            }
        } catch (SQLException e) {
            throw new GastoException("Erro ao listar os gastos.", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new GastoException("Erro ao fechar a conexão.", e);
            }
        }
        return lista;
    }

    public void remover(Integer codigo) throws GastoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM T_GASTO WHERE T_LANCAMENTO_CD_LANCAMENTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new GastoException("Erro ao remover o gasto.", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new GastoException("Erro ao fechar a conexão.", e);
            }
        }
    }

    public Gasto buscarPorId(Integer codigo) throws GastoException {
        Gasto gasto = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM T_GASTO WHERE T_LANCAMENTO_CD_LANCAMENTO = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer t_lancamento_cd_lancamento = rs.getInt("T_LANCAMENTO_CD_LANCAMENTO");
                String ds_local = rs.getString("DS_LOCAL");

                gasto = new Gasto(t_lancamento_cd_lancamento, ds_local);
            }
        } catch (SQLException e) {
            throw new GastoException("Erro ao buscar o gasto.", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new GastoException("Erro ao fechar a conexão.", e);
            }
        }
        return gasto;
    }

    public void atualizar(Gasto gasto) throws GastoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE T_GASTO SET DS_LOCAL = ? WHERE T_LANCAMENTO_CD_LANCAMENTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, gasto.getDs_local());
            stmt.setInt(2, gasto.getT_lancamento_cd_lancamento());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new GastoException("Erro ao atualizar o gasto.", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new GastoException("Erro ao fechar a conexão.", e);
            }
        }
    }
}