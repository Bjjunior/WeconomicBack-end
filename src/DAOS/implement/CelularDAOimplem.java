package DAOS.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Conexao;
import DAOS.CelularDAO;
import Exceptions.CelularException;
import Classes.Celular;

public class CelularDAOimplem implements CelularDAO {

    private Connection conexao;

    public void cadastrar(Celular celular) throws CelularException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO t_celular (cd_celular, nr_ddi, nr_ddd, nr_celular) VALUES (?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, celular.getCd_celular());
            stmt.setInt(2, celular.getNr_ddi());
            stmt.setInt(3, celular.getNr_ddd());
            stmt.setInt(4, celular.getNr_celular());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new CelularException("Erro ao cadastrar celular.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new CelularException("Erro ao fechar o statement.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CelularException("Erro ao fechar a conexão.", e);
                }
            }
        }
    }

    public List<Celular> listar() throws CelularException {
        List<Celular> lista = new ArrayList<Celular>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_celular");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer cdCelular = rs.getInt("cd_celular");
                Integer nrDdi = rs.getInt("nr_ddi");
                Integer nrDdd = rs.getInt("nr_ddd");
                Integer nrCelular = rs.getInt("nr_celular");

                Celular celular = new Celular(cdCelular, nrDdi, nrDdd, nrCelular);
                lista.add(celular);
            }
        } catch (SQLException e) {
            throw new CelularException("Erro ao listar celulares.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new CelularException("Erro ao fechar o statement ou o result set.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CelularException("Erro ao fechar a conexão.", e);
                }
            }
        }
        return lista;
    }

    public void remover(Integer codigo) throws CelularException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM t_celular WHERE cd_celular = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new CelularException("Erro ao remover celular.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new CelularException("Erro ao fechar o statement.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CelularException("Erro ao fechar a conexão.", e);
                }
            }
        }
    }

    public Celular buscarPorCodigo(Integer codigo) throws CelularException {
        Celular celular = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_celular WHERE cd_celular = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer cdCelular = rs.getInt("cd_celular");
                Integer nrDdi = rs.getInt("nr_ddi");
                Integer nrDdd = rs.getInt("nr_ddd");
                Integer nrCelular = rs.getInt("nr_celular");

                celular = new Celular(cdCelular, nrDdi, nrDdd, nrCelular);
            }
        } catch (SQLException e) {
            throw new CelularException("Erro ao buscar celular por código.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new CelularException("Erro ao fechar o statement ou o result set.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CelularException("Erro ao fechar a conexão.", e);
                }
            }
        }
        return celular;
    }

    public void atualizar(Celular celular) throws CelularException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE t_celular SET nr_ddi = ?, nr_ddd = ?, nr_celular = ? WHERE cd_celular = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, celular.getNr_ddi());
            stmt.setInt(2, celular.getNr_ddd());
            stmt.setInt(3, celular.getNr_celular());
            stmt.setInt(4, celular.getCd_celular());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new CelularException("Erro ao atualizar celular.", e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new CelularException("Erro ao fechar o statement.", e);
            } finally {
                try {
                    if (conexao != null)
                        conexao.close();
                } catch (SQLException e) {
                    throw new CelularException("Erro ao fechar a conexão.", e);
                }
            }
        }
    }
}