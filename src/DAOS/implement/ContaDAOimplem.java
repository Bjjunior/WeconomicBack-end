package DAOS.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Conexao;
import Classes.Conta;
import DAOS.ContaDAO;
import Exceptions.ContaException;

public class ContaDAOimplem implements ContaDAO {

    private Connection conexao;

    public void cadastrar(Conta conta) throws ContaException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO T_CONTA (CD_CONTA, T_USUARIO_CD_USUARIO, T_TIPO_CONTA_CD_TIPO_CONTA, NM_CONTA, VL_SALDO) VALUES (?, ?, ?, ?, ?, )";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, conta.getCd_conta());
            stmt.setInt(2, conta.getT_usuario_cd_usuario());
            stmt.setInt(3, conta.getT_tipo_conta_cd_tipo_conta());
            stmt.setString(4, conta.getNm_conta());
            stmt.setDouble(5, conta.getVl_saldo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new ContaException("Erro ao cadastrar a conta.", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new ContaException("Erro ao fechar a conexão.", e);
            }
        }
    }

    public List<Conta> listar() throws ContaException {
        List<Conta> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM T_CONTA");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer cd_conta = rs.getInt("CD_CONTA");
                Integer t_usuario_cd_usuario = rs.getInt("T_USUARIO_CD_USUARIO");
                Integer t_tipo_conta_cd_tipo_conta = rs.getInt("T_TIPO_CONTA_CD_TIPO_CONTA");
                String nm_conta = rs.getString("NM_CONTA");
                Double vl_saldo = rs.getDouble("VL_SALDO");

                Conta conta = new Conta(cd_conta, t_usuario_cd_usuario, t_tipo_conta_cd_tipo_conta, nm_conta, vl_saldo);

                lista.add(conta);

            }
        } catch (SQLException e) {
            throw new ContaException("Erro ao listar as contas.", e);
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
                throw new ContaException("Erro ao fechar a conexão.", e);
            }
        }
        return lista;
    }

    public void remover(Integer cd_conta) throws ContaException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM T_CONTA WHERE CD_CONTA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cd_conta);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ContaException("Erro ao remover a conta.", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new ContaException("Erro ao fechar a conexão.", e);
            }
        }
    }

    public Conta buscarPorCd(Integer codigo) throws ContaException {
        Conta conta = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM T_CONTA WHERE CD_CONTA = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer cd_conta = rs.getInt("CD_CONTA");
                Integer t_usuario_cd_usuario = rs.getInt("T_USUARIO_CD_USUARIO");
                Integer t_tipo_conta_cd_tipo_conta = rs.getInt("T_TIPO_CONTA_CD_TIPO_CONTA");
                String nm_conta = rs.getString("NM_CONTA");
                Double vl_saldo = rs.getDouble("VL_SALDO");

                conta = new Conta(cd_conta, t_usuario_cd_usuario, t_tipo_conta_cd_tipo_conta, nm_conta, vl_saldo);
            }
        } catch (SQLException e) {
            throw new ContaException("Erro ao buscar a conta.", e);
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
                throw new ContaException("Erro ao fechar a conexão.", e);
            }
        }
        return conta;
    }

    public void atualizar(Conta conta) throws ContaException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE T_CONTA SET T_USUARIO_CD_USUARIO = ?, T_TIPO_CONTA_CD_TIPO_CONTA = ?, NM_CONTA = ?, VL_SALDO = ? WHERE CD_CONTA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, conta.getT_usuario_cd_usuario());
            stmt.setInt(2, conta.getT_tipo_conta_cd_tipo_conta());
            stmt.setString(3, conta.getNm_conta());
            stmt.setDouble(4, conta.getVl_saldo());
            stmt.setInt(6, conta.getCd_conta());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new ContaException("Erro ao atualizar a conta.", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new ContaException("Erro ao fechar a conexão.", e);
            }
        }
    }
}
