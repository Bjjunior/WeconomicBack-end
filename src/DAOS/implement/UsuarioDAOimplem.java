package DAOS.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Conexao;
import Classes.Usuario;
import DAOS.UsuarioDAO;
import Exceptions.UsuarioException;

public class UsuarioDAOimplem implements UsuarioDAO {

    private Connection conexao;

    public void cadastrar(Usuario usuario) throws UsuarioException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "INSERT INTO t_usuario (cd_usuario, t_nome_cd_nome, t_celular_cd_celular, ds_email, ds_senha, dt_nasc) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuario.getCd_usuario());
            stmt.setInt(2, usuario.getT_nome_cd_nome());
            stmt.setInt(3, usuario.getT_celular_cd_celular());
            stmt.setString(4, usuario.getDs_email());
            stmt.setString(5, usuario.getDs_senha());
            stmt.setDate(6, usuario.getDt_nasc());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new UsuarioException("Erro ao cadastrar o usuário: " + e.getMessage());
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

    public List<Usuario> listar() throws UsuarioException {
        List<Usuario> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Integer cd_usuario = rs.getInt("cd_usuario");
                Integer t_nome_cd_nome = rs.getInt("t_nome_cd_nome");
                Integer t_celular_cd_celular = rs.getInt("t_celular_cd_celular");
                String ds_email = rs.getString("ds_email");
                String ds_senha = rs.getString("ds_senha");
                java.sql.Date dt_nasc = rs.getDate("dt_nasc");

                Usuario usuario = new Usuario(cd_usuario, t_nome_cd_nome, t_celular_cd_celular, ds_email, ds_senha,
                        dt_nasc);
                lista.add(usuario);
            }
        } catch (SQLException e) {
            throw new UsuarioException("Erro ao listar os usuários: " + e.getMessage());
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

    public void remover(Integer cd_usuario) throws UsuarioException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "DELETE FROM t_usuario WHERE cd_usuario = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cd_usuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new UsuarioException("Erro ao remover o usuário: " + e.getMessage());
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

    public Usuario buscarPorCodigo(Integer cdusuario) throws UsuarioException {
        Usuario usuario = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM t_usuario WHERE cd_usuario = ?");
            stmt.setInt(1, cdusuario);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Integer cd_usuario = rs.getInt("cd_usuario");
                Integer t_nome_cd_nome = rs.getInt("t_nome_cd_nome");
                Integer t_celular_cd_celular = rs.getInt("t_celular_cd_celular");
                String ds_email = rs.getString("ds_email");
                String ds_senha = rs.getString("ds_senha");
                java.sql.Date dt_nasc = rs.getDate("dt_nasc");

                usuario = new Usuario(cd_usuario, t_nome_cd_nome, t_celular_cd_celular, ds_email, ds_senha,
                        dt_nasc);
            }
        } catch (SQLException e) {
            throw new UsuarioException("Erro ao buscar o usuário: " + e.getMessage());
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
        return usuario;
    }

    public void atualizar(Usuario usuario) throws UsuarioException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.obterConexao();
            String sql = "UPDATE t_usuario SET t_nome_cd_nome = ?, t_celular_cd_celular = ?, ds_email = ?, ds_senha = ?, dt_nasc = ? WHERE cd_usuario = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuario.getT_nome_cd_nome());
            stmt.setInt(2, usuario.getT_celular_cd_celular());
            stmt.setString(3, usuario.getDs_email());
            stmt.setString(4, usuario.getDs_senha());
            stmt.setDate(5, usuario.getDt_nasc());
            stmt.setInt(6, usuario.getCd_usuario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new UsuarioException("Erro ao atualizar o usuário: " + e.getMessage());
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
