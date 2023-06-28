package DAOS.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Conexao;
import Classes.Nome;
import DAOS.NomeDAO;
import Exceptions.NomeException;

public class NomeDAOimplem implements NomeDAO {

    private Connection conexao;

    public void cadastrar(Nome nome) throws NomeException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO t_nome (cd_nome, ds_primeiro_nome, ds_sobrenome, ds_apelido) VALUES (?,?,?,?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, nome.getCd_nome());
            stmt.setString(2, nome.getDs_primeiro_nome());
            stmt.setString(3, nome.getDs_sobrenome());
            stmt.setString(4, nome.getDs_apelido());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new NomeException("Erro ao cadastrar o nome: " + e.getMessage());
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

    public List<Nome> listar() throws NomeException {
        List<Nome> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_nome");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer cdNome = rs.getInt("cd_nome");
                String dsPrimeiroNome = rs.getString("ds_primeiro_nome");
                String dsSobrenome = rs.getString("ds_sobrenome");
                String dsApelido = rs.getString("ds_apelido");

                Nome nome = new Nome(cdNome, dsPrimeiroNome, dsSobrenome, dsApelido);
                lista.add(nome);
            }
        } catch (SQLException e) {
            throw new NomeException("Erro ao listar os nomes: " + e.getMessage());
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

    public void remover(Integer codigo) throws NomeException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM t_nome WHERE cd_nome = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new NomeException("Erro ao remover o nome: " + e.getMessage());
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

    public Nome buscarPorCodigo(Integer codigo) throws NomeException {
        Nome nome = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_nome WHERE cd_nome = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer cdNome = rs.getInt("cd_nome");
                String dsPrimeiroNome = rs.getString("ds_primeiro_nome");
                String dsSobrenome = rs.getString("ds_sobrenome");
                String dsApelido = rs.getString("ds_apelido");

                nome = new Nome(cdNome, dsPrimeiroNome, dsSobrenome, dsApelido);
            }
        } catch (SQLException e) {
            throw new NomeException("Erro ao buscar o nome: " + e.getMessage());
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
        return nome;
    }

    public void atualizar(Nome nome) throws NomeException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE t_nome SET ds_primeiro_nome = ?, ds_sobrenome = ?, ds_apelido = ? WHERE cd_nome = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome.getDs_primeiro_nome());
            stmt.setString(2, nome.getDs_sobrenome());
            stmt.setString(3, nome.getDs_apelido());
            stmt.setInt(4, nome.getCd_nome());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new NomeException("Erro ao atualizar o nome: " + e.getMessage());
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
