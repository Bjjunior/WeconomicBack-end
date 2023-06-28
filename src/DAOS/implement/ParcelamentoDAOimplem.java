package DAOS.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Conexao;
import Classes.Parcelamento;
import DAOS.ParcelamentoDAO;
import Exceptions.ParcelamentoException;

public class ParcelamentoDAOimplem implements ParcelamentoDAO {

    private Connection conexao;

    public void cadastrar(Parcelamento parcelamento) throws ParcelamentoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO t_parcelamento (cd_parcelamento, qt_parcela) VALUES (?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, parcelamento.getCd_parcelamento());
            stmt.setInt(2, parcelamento.getQt_parcela());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new ParcelamentoException("Erro ao cadastrar o parcelamento: " + e.getMessage());
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

    public List<Parcelamento> listar() throws ParcelamentoException {
        List<Parcelamento> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_parcelamento");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer cdParcelamento = rs.getInt("cd_parcelamento");
                Integer qtParcela = rs.getInt("qt_parcela");

                Parcelamento parcelamento = new Parcelamento(cdParcelamento, qtParcela);
                lista.add(parcelamento);
            }
        } catch (SQLException e) {
            throw new ParcelamentoException("Erro ao listar os parcelamentos: " + e.getMessage());
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

    public void remover(Integer codigo) throws ParcelamentoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM t_parcelamento WHERE cd_parcelamento = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ParcelamentoException("Erro ao remover o parcelamento: " + e.getMessage());
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

    public Parcelamento buscarPorCodigo(Integer codigo) throws ParcelamentoException {
        Parcelamento parcelamento = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_parcelamento WHERE cd_parcelamento = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer cdParcelamento = rs.getInt("cd_parcelamento");
                Integer qtParcela = rs.getInt("qt_parcela");

                parcelamento = new Parcelamento(cdParcelamento, qtParcela);
            }
        } catch (SQLException e) {
            throw new ParcelamentoException("Erro ao buscar o parcelamento: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return parcelamento;
    }

    public void atualizar(Parcelamento parcelamento) throws ParcelamentoException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE t_parcelamento SET qt_parcela = ? WHERE cd_parcelamento = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, parcelamento.getQt_parcela());
            stmt.setInt(2, parcelamento.getCd_parcelamento());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ParcelamentoException("Erro ao atualizar o parcelamento: " + e.getMessage());
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