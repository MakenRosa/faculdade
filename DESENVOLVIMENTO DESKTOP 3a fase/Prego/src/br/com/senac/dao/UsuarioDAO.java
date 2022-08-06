package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
    void salvar(Usuario usuario) throws SQLException;
    void alterar(Usuario usuario) throws SQLException;
    void excluir(Integer id) throws SQLException;
    Usuario pesquisarPorId(Integer id) throws SQLException;
    List<Usuario> pesquisarTodos() throws SQLException;
    List<Usuario> PesquisarPorNome(String nome) throws SQLException;
}
