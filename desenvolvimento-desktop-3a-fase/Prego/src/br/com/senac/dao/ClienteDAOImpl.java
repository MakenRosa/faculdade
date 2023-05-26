
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO{
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    @Override
    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente(nome, cpf, rg, salario) values (?, ?, ?, ?)";
        try {
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getRg());
            statement.setDouble(4, cliente.getSalario());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            cliente.setId(resultSet.getInt(1));
            System.out.println(cliente.getId());
        } catch (SQLException e) {
            System.err.println("Erro ao salvar! " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
    }

    @Override
    public void alterar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nome = ? , rg = ? , cpf = ? , salario = ? WHERE id = ?";
        try{
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getRg());
            statement.setString(3, cliente.getCpf());
            statement.setDouble(4, cliente.getSalario());
            statement.setInt(5, cliente.getId());
            statement.executeUpdate();
        } catch (SQLException ex){
            System.err.println("Erro ao alterar cliente! " + ex.getMessage());
        } finally {
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try{
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex){
            System.err.println("Erro ao excluir Cliente! " + ex.getMessage());
        } finally{
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
    }

    @Override
    public Cliente pesquisarPorId(Integer id) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        Cliente cliente = null;
        try{
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                cliente = new Cliente();
                cliente.setId(id);
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setRg(resultSet.getString("rg"));
                cliente.setSalario(resultSet.getDouble("salario"));
                return cliente;
            }
        } catch(SQLException ex){
            System.err.println("Erro ao pesquisar por id! "+ ex.getMessage());
        } finally {
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public List<Cliente> pesquisarTodos() throws SQLException {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList();
        try {
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Cliente cliente = new Cliente(resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("rg"),
                        resultSet.getDouble("salario"));
                cliente.setId(resultSet.getInt("id"));
                clientes.add(cliente);
            }
            return clientes;
        } catch(SQLException ex){
            System.err.println("Erro ao pesquisar todos! "+ ex.getMessage());
        } finally {
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
        return null;}

    @Override
    public List<Cliente> PesquisarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        List<Cliente> clientes = new ArrayList();
        try {
            connection = FabricaConexao.abrirConexao();
            statement = connection.prepareStatement(sql);
            statement.setString(1,"%" + nome.replace(' ', '%') + "%");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Cliente cliente = new Cliente(resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("rg"),
                        resultSet.getFloat("salario"));
                cliente.setId(resultSet.getInt("id"));
                clientes.add(cliente);
            }
            return clientes;
        } catch(SQLException ex){
            System.err.println("Erro ao pesquisar todos! "+ ex.getMessage());
        } finally {
            FabricaConexao.fecharConexao(connection, statement, resultSet);
        }
        return null;
    }
}
