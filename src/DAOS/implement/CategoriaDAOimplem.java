
package DAOS.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Conexao;
import DAOS.CategoriaDAO;
import Exceptions.CategoriaException;
import Classes.Categoria;

public class CategoriaDAOimplem implements CategoriaDAO {

    private Connection conexao;

    public void cadastrar(Categoria categoria) throws CategoriaException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO t_categoria (cd_categoria, nm_categoria) VALUES (?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, categoria.getCd_categoria());
            stmt.setString(2, categoria.getNm_categoria());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new CategoriaException("Erro ao cadastrar categoria.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new CategoriaException("Erro ao fechar o statement.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CategoriaException("Erro ao fechar a conexão.", e);
                }
            }
        }
    }

    public List<Categoria> listar() throws CategoriaException {
        List<Categoria> lista = new ArrayList<Categoria>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_categoria");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer cdCategoria = rs.getInt("cd_categoria");
                String nmCategoria = rs.getString("nm_categoria");

                Categoria categoria = new Categoria(cdCategoria, nmCategoria);
                lista.add(categoria);
            }
        } catch (SQLException e) {
            throw new CategoriaException("Erro ao listar categorias.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new CategoriaException("Erro ao fechar o statement ou o result set.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CategoriaException("Erro ao fechar a conexão.", e);
                }
            }
        }
        return lista;
    }

    public void remover(Integer codigo) throws CategoriaException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM t_categoria WHERE cd_categoria = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new CategoriaException("Erro ao remover categoria.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new CategoriaException("Erro ao fechar o statement.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CategoriaException("Erro ao fechar a conexão.", e);
                }
            }
        }
    }

    public Categoria buscarPorCodigo(Integer codigo) throws CategoriaException {
        Categoria categoria = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_categoria WHERE cd_categoria = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer cdCategoria = rs.getInt("cd_categoria");
                String nmCategoria = rs.getString("nm_categoria");

                categoria = new Categoria(cdCategoria, nmCategoria);
            }
        } catch (SQLException e) {
            throw new CategoriaException("Erro ao buscar categoria por código.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new CategoriaException("Erro ao fechar o statement ou o result set.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CategoriaException("Erro ao fechar a conexão.", e);
                }
            }
        }
        return categoria;
    }

    public void atualizar(Categoria categoria) throws CategoriaException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE t_categoria SET nm_categoria = ? WHERE cd_categoria = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, categoria.getNm_categoria());
            stmt.setInt(2, categoria.getCd_categoria());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new CategoriaException("Erro ao atualizar categoria.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new CategoriaException("Erro ao fechar o statement.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CategoriaException("Erro ao fechar a conexão.", e);
                }
            }
        }
    }
}