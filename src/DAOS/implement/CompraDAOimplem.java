package DAOS.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Conexao;
import DAOS.CompraDAO;
import Exceptions.CompraException;
import Classes.Compra;

public class CompraDAOimplem implements CompraDAO {
    private Connection conexao;

    public void cadastrar(Compra compra) throws CompraException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO t_compra (cd_compra, t_cartao_cr_cd_cartao, t_parcelamento_cd_parcelamento, t_categoria_cd_categoria, dt_compra, vl_compra, tx_descricao, ds_local, cd_cartao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, compra.getCd_compra());
            stmt.setInt(2, compra.getT_cartao_cr_cd_cartao());
            stmt.setInt(3, compra.getT_parcelamento_cd_parcelamento());
            stmt.setInt(4, compra.getT_categoria_cd_categoria());
            stmt.setDate(5, compra.getDt_compra());
            stmt.setDouble(6, compra.getVl_compra());
            stmt.setString(7, compra.getTx_descricao());
            stmt.setString(8, compra.getDs_local());
            stmt.setInt(9, compra.getCd_cartao());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new CompraException("Erro ao cadastrar a compra.", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new CompraException("Erro ao fechar a conexão.", e);
            }
        }
    }

    public List<Compra> listar() {
        List<Compra> lista = new ArrayList<Compra>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_compra");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer cdCompra = rs.getInt("cd_compra");
                Integer tCartaoCrCdCartao = rs.getInt("t_cartao_cr_cd_cartao");
                Integer tParcelamentoCdParcelamento = rs.getInt("t_parcelamento_cd_parcelamento");
                Integer tCategoriaCdCategoria = rs.getInt("t_categoria_cd_categoria");
                Date dtCompra = rs.getDate("dt_compra");
                Double vlCompra = rs.getDouble("vl_compra");
                String txDescricao = rs.getString("tx_descricao");
                String dsLocal = rs.getString("ds_local");
                Integer cdCartao = rs.getInt("cd_cartao");

                Compra compra = new Compra(cdCompra, tCartaoCrCdCartao, tParcelamentoCdParcelamento,
                        tCategoriaCdCategoria, dtCompra, vlCompra, txDescricao, dsLocal, cdCartao);
                lista.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public void remover(Integer codigo) throws CompraException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM t_compra WHERE cd_compra = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new CompraException("Erro ao remover a compra.", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new CompraException("Erro ao fechar a conexão.", e);
            }
        }
    }

    public Compra buscarPorCodigo(Integer codigo) {
        Compra compra = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_compra WHERE cd_compra = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer cdCompra = rs.getInt("cd_compra");
                Integer tCartaoCrCdCartao = rs.getInt("t_cartao_cr_cd_cartao");
                Integer tParcelamentoCdParcelamento = rs.getInt("t_parcelamento_cd_parcelamento");
                Integer tCategoriaCdCategoria = rs.getInt("t_categoria_cd_categoria");
                Date dtCompra = rs.getDate("dt_compra");
                Double vlCompra = rs.getDouble("vl_compra");
                String txDescricao = rs.getString("tx_descricao");
                String dsLocal = rs.getString("ds_local");
                Integer cdCartao = rs.getInt("cd_cartao");

                compra = new Compra(cdCompra, tCartaoCrCdCartao, tParcelamentoCdParcelamento, tCategoriaCdCategoria,
                        dtCompra, vlCompra, txDescricao, dsLocal, cdCartao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return compra;
    }

    public void atualizar(Compra compra) throws CompraException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE t_compra SET t_cartao_cr_cd_cartao = ?, t_parcelamento_cd_parcelamento = ?, t_categoria_cd_categoria = ?, dt_compra = ?, vl_compra = ?, tx_descricao = ?, ds_local = ?, cd_cartao = ? WHERE cd_compra = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, compra.getT_cartao_cr_cd_cartao());
            stmt.setInt(2, compra.getT_parcelamento_cd_parcelamento());
            stmt.setInt(3, compra.getT_categoria_cd_categoria());
            stmt.setDate(4, compra.getDt_compra());
            stmt.setDouble(5, compra.getVl_compra());
            stmt.setString(6, compra.getTx_descricao());
            stmt.setString(7, compra.getDs_local());
            stmt.setInt(8, compra.getCd_cartao());
            stmt.setInt(9, compra.getCd_compra());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new CompraException("Erro ao atualizar a compra.", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new CompraException("Erro ao fechar a conexão.", e);
            }
        }
    }
}