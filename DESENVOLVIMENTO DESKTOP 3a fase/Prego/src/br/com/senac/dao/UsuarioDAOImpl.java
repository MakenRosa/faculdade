package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO{
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    @Override
    public void salvar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario(nome, login, senha) values (?, ?, ?)";
        try {
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            usuario.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            System.err.println("Erro ao salvar! " + e.getMessage());
        }
    }

    @Override
    public void alterar(Usuario usuario) throws SQLException {

    }

    @Override
    public void excluir(Integer id) throws SQLException {

    }

    @Override
    public Usuario pesquisarPorId(Integer id) throws SQLException {
        return null;

    }

    @Override
    public List<Usuario> pesquisarTodos() throws SQLException {
        return null;

    }

    @Override
    public List<Usuario> PesquisarPorNome(String nome) throws SQLException {
        return null;

    }
    
}
