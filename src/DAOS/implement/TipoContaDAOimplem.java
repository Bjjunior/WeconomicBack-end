
package DAOS.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Conexao;
import Classes.TipoConta;
import DAOS.TipoContaDAO;

public class TipoContaDAOimplem implements TipoContaDAO {

    private Connection conexao;

    public void cadastrar(TipoConta tipoConta) {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO T_TIPO_CONTA (CD_TIPO_CONTA, DS_TIPO_CONTA) VALUES (?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, tipoConta.getCd_tipo_conta());
            stmt.setString(2, tipoConta.getDs_tipo_conta());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<TipoConta> listar() {
        List<TipoConta> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM T_TIPO_CONTA");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer cdTipoConta = rs.getInt("CD_TIPO_CONTA");
                String dsTipoConta = rs.getString("DS_TIPO_CONTA");

                TipoConta tipoConta = new TipoConta(cdTipoConta, dsTipoConta);
                lista.add(tipoConta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    public void remover(Integer codigo) {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM T_TIPO_CONTA WHERE CD_TIPO_CONTA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public TipoConta buscarPorCd(Integer codigo) {
        TipoConta tipoConta = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM T_TIPO_CONTA WHERE CD_TIPO_CONTA = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer cdTipoConta = rs.getInt("CD_TIPO_CONTA");
                String dsTipoConta = rs.getString("DS_TIPO_CONTA");

                tipoConta = new TipoConta(cdTipoConta, dsTipoConta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tipoConta;
    }

    public void atualizar(TipoConta tipoConta) {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE T_TIPO_CONTA SET DS_TIPO_CONTA = ? WHERE CD_TIPO_CONTA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tipoConta.getDs_tipo_conta());
            stmt.setInt(2, tipoConta.getCd_tipo_conta());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}