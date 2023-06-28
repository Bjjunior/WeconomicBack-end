package DAOS.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Conexao;
import Classes.Recebimento;
import DAOS.RecebimentoDAO;
import Exceptions.RecebimentoException;

public class RecebimentoDAOimplem implements RecebimentoDAO {

    private Connection conexao;

    public void cadastrar(Recebimento recebimento) throws RecebimentoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO t_recebimento (t_lancamento_cd_lcto, ds_origem) VALUES (?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, recebimento.getT_lancamento_cd_lcto());
            stmt.setString(2, recebimento.getDs_origem());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RecebimentoException("Erro ao cadastrar o recebimento: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Recebimento> listar() throws RecebimentoException {
        List<Recebimento> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_recebimento");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer t_lancamento_cd_lcto = rs.getInt("t_lancamento_cd_lcto");
                String ds_origem = rs.getString("ds_origem");

                Recebimento recebimento = new Recebimento(t_lancamento_cd_lcto, ds_origem);
                lista.add(recebimento);
            }
        } catch (SQLException e) {
            throw new RecebimentoException("Erro ao listar os recebimentos: " + e.getMessage());
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
                e.printStackTrace();
            }
        }
        return lista;
    }

    public void remover(Integer codigoLancamento) throws RecebimentoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM t_recebimento WHERE t_lancamento_cd_lcto = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigoLancamento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RecebimentoException("Erro ao remover o recebimento: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Recebimento buscarPorCodigo(Integer codigoLancamento) throws RecebimentoException {
        Recebimento recebimento = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_recebimento WHERE t_lancamento_cd_lcto = ?");
            stmt.setInt(1, codigoLancamento);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer t_lancamento_cd_lcto = rs.getInt("t_lancamento_cd_lcto");
                String ds_origem = rs.getString("ds_origem");

                recebimento = new Recebimento(t_lancamento_cd_lcto, ds_origem);
            }
        } catch (SQLException e) {
            throw new RecebimentoException("Erro ao buscar o recebimento: " + e.getMessage());
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
                e.printStackTrace();
            }
        }
        return recebimento;
    }

    public void atualizar(Recebimento recebimento) throws RecebimentoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE t_recebimento SET ds_origem = ? WHERE t_lancamento_cd_lcto = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, recebimento.getDs_origem());
            stmt.setInt(2, recebimento.getT_lancamento_cd_lcto());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RecebimentoException("Erro ao atualizar o recebimento: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}