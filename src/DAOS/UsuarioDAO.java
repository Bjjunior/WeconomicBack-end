package DAOS;

import java.util.List;

import Classes.Usuario;
import Exceptions.UsuarioException;

public interface UsuarioDAO {

    public void cadastrar(Usuario usuario) throws UsuarioException;

    public List<Usuario> listar() throws UsuarioException;

    public void remover(Integer cd_usuario) throws UsuarioException;

    public Usuario buscarPorCodigo(Integer cd_usuario) throws UsuarioException;

    public void atualizar(Usuario usuario) throws UsuarioException;
}
