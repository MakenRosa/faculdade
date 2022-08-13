package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        } finally {
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
    }

    @Override
    public void alterar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nome = ? , login = ? , senha = ? WHERE id_usuario = ?";
        try{
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
            statement.setInt(4, usuario.getId());
            statement.executeUpdate();
        } catch (SQLException ex){
            System.err.println("Erro ao alterar usuário! " + ex.getMessage());
        } finally {
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try{
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex){
            System.err.println("Erro ao excluir usuário! " + ex.getMessage());
        } finally{
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
    }

    @Override
    public Usuario pesquisarPorId(Integer id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        Usuario usuario = null;
        try{
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                usuario = new Usuario();
                usuario.setId(id);
                usuario.setLogin(resultSet.getString("login"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setUltimoAcesso(resultSet.getDate("ultimo_acesso"));
                return usuario;
            }
        } catch(SQLException ex){
            System.err.println("Erro ao pesquisar por id! "+ ex.getMessage());
        } finally{
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public List<Usuario> pesquisarTodos() throws SQLException {
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList();
        try {
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Usuario usuario = new Usuario(resultSet.getString("nome"),
                        resultSet.getString("login"),
                        resultSet.getString("senha"));
                usuario.setId(resultSet.getInt("id_usuario"));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch(SQLException ex){
            System.err.println("Erro ao pesquisar todos! "+ ex.getMessage());
        } finally {
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
        return null;

    }

    @Override
    public List<Usuario> PesquisarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE nome LIKE ?";
        List<Usuario> usuarios = new ArrayList();
        try {
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql);
            statement.setString(1,"%" + nome.replace(' ', '%') + "%");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Usuario usuario = new Usuario(resultSet.getString("nome"),
                        resultSet.getString("login"),
                        resultSet.getString("senha"));
                usuario.setId(resultSet.getInt("id_usuario"));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch(SQLException ex){
            System.err.println("Erro ao pesquisar todos! "+ ex.getMessage());
        } finally {
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
        return null;

    }
    
}
