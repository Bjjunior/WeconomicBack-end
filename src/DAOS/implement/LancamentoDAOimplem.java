package DAOS.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Conexao;
import Classes.Lancamento;
import DAOS.LancamentoDAO;
import Exceptions.LancamentoException;

public class LancamentoDAOimplem implements LancamentoDAO {

    private Connection conexao;

    public void cadastrar(Lancamento lancamento) throws LancamentoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO T_LANCAMENTO (CD_LCTO, T_CONTA_CD_CONTA, T_CATEGORIA_CD_CATEGORIA, DT_LCTO, VL_LCTO, TX_DESCRICAO, CD_CONTA, TP_LCTO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, lancamento.getCd_lcto());
            stmt.setInt(2, lancamento.getT_conta_cd_conta());
            stmt.setInt(3, lancamento.getT_categoria_cd_categoria());
            stmt.setDate(4, lancamento.getDt_lcto());
            stmt.setDouble(5, lancamento.getVl_lcto());
            stmt.setString(6, lancamento.getTx_descricao());
            stmt.setInt(7, lancamento.getCd_conta());
            stmt.setString(8, lancamento.getTp_lcto());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new LancamentoException("Erro ao cadastrar o lançamento: " + e.getMessage());
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

    public List<Lancamento> listar() throws LancamentoException {
        List<Lancamento> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM T_LANCAMENTO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer cd_lcto = rs.getInt("CD_LCTO");
                Integer t_conta_cd_conta = rs.getInt("T_CONTA_CD_CONTA");
                Integer t_categoria_cd_categoria = rs.getInt("T_CATEGORIA_CD_CATEGORIA");
                java.sql.Date dt_lcto = rs.getDate("DT_LCTO");
                Double vl_lcto = rs.getDouble("VL_LCTO");
                String tx_descricao = rs.getString("TX_DESCRICAO");
                Integer cd_conta = rs.getInt("CD_CONTA");
                String tp_lcto = rs.getString("TP_LCTO");

                Lancamento lancamento = new Lancamento(cd_lcto, t_conta_cd_conta, t_categoria_cd_categoria, dt_lcto,
                        vl_lcto, tx_descricao, cd_conta, tp_lcto);
                lista.add(lancamento);
            }
        } catch (SQLException e) {
            throw new LancamentoException("Erro ao listar os lançamentos: " + e.getMessage());
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

    public void remover(Integer cd_lcto) throws LancamentoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM T_LANCAMENTO WHERE CD_LCTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cd_lcto);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new LancamentoException("Erro ao remover o lançamento: " + e.getMessage());
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

    public void atualizar(Lancamento lancamento) throws LancamentoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE T_LANCAMENTO SET T_CONTA_CD_CONTA = ?, T_CATEGORIA_CD_CATEGORIA = ?, DT_LCTO = ?, VL_LCTO = ?, TX_DESCRICAO = ?, CD_CONTA = ?, TP_LCTO = ? WHERE CD_LCTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, lancamento.getT_conta_cd_conta());
            stmt.setInt(2, lancamento.getT_categoria_cd_categoria());
            stmt.setDate(3, lancamento.getDt_lcto());
            stmt.setDouble(4, lancamento.getVl_lcto());
            stmt.setString(5, lancamento.getTx_descricao());
            stmt.setInt(6, lancamento.getCd_conta());
            stmt.setString(7, lancamento.getTp_lcto());
            stmt.setInt(8, lancamento.getCd_lcto());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new LancamentoException("Erro ao atualizar o lançamento: " + e.getMessage());
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

    public Lancamento buscarPorCodigo(Integer cdlcto) throws LancamentoException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Lancamento lancamento = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "SELECT * FROM T_LANCAMENTO WHERE CD_LCTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cdlcto);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer cd_lcto = rs.getInt("CD_LCTO");
                Integer t_conta_cd_conta = rs.getInt("T_CONTA_CD_CONTA");
                Integer t_categoria_cd_categoria = rs.getInt("T_CATEGORIA_CD_CATEGORIA");
                java.sql.Date dt_lcto = rs.getDate("DT_LCTO");
                Double vl_lcto = rs.getDouble("VL_LCTO");
                String tx_descricao = rs.getString("TX_DESCRICAO");
                Integer cd_conta = rs.getInt("CD_CONTA");
                String tp_lcto = rs.getString("TP_LCTO");

                lancamento = new Lancamento(cd_lcto, t_conta_cd_conta, t_categoria_cd_categoria, dt_lcto,
                        vl_lcto, tx_descricao, cd_conta, tp_lcto);
            }
        } catch (SQLException e) {
            throw new LancamentoException("Erro ao buscar o lançamento: " + e.getMessage());
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
        return lancamento;
    }
}