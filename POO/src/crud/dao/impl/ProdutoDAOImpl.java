package crud.dao.impl;

import crud.dao.ConnectionManager;
import crud.dao.ProdutoDAO;
import crud.entidades.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAOImpl implements ProdutoDAO{

    @Override
    public void criarTabela() throws Exception{
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionManager.openConnection();
            statement = connection.createStatement();
            statement.executeUpdate(strCreateTabela());
        } catch (SQLException ex){
            System.err.println("Erro ao criar tabela! " + ex.getMessage());
        } finally {
            crud.dao.ConnectionManager.closeConnection(connection, statement);
        }
    }
    
    private String strCreateTabela(){
    StringBuilder sql = new StringBuilder();
    sql.append("CREATE TABLE IF NOT EXISTS produto ( ");
    sql.append("id int NOT NULL AUTO_INCREMENT, ");
    sql.append("nome varchar(45) NOT NULL, ");
    sql.append("preco decimal(10,2) NOT NULL DEFAULT '0.00', ");
    sql.append("vencimento date NOT NULL, ");
    sql.append("PRIMARY KEY (id)");
    sql.append(")");
    
    return sql.toString();
    }

    @Override
    public Produto criar(Produto produto) throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String sql = "INSERT INTO produto (nome, preco, vencimento) values(?, ?, ?)";
        try {
            connection = ConnectionManager.openConnection();
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setDate(3, Date.valueOf(produto.getDataVencimento()));
            statement.executeUpdate();
            resultado = statement.getGeneratedKeys();
            if (resultado.next()){
                produto.setId(resultado.getLong(1));
            }
        } catch (SQLException ex){
            System.err.println("Erro ao criar produto! " + ex.getMessage());
        } finally {
            crud.dao.ConnectionManager.closeConnection(connection, statement, resultado);
        }
        return produto;
    }

    @Override
    public Produto buscarPeloId(long id) throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        Produto produto = null;
        try {
            connection = ConnectionManager.openConnection();
            String sql = "SELECT * FROM produto WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            resultado = statement.executeQuery();
            if (resultado.next()){
                produto = new Produto();
                produto.setId(id);
                produto.setNome(resultado.getString("nome"));
                produto.setPreco(resultado.getDouble("preco"));
                produto.setDataVencimento(resultado.getDate("vencimento").toLocalDate());
            }
        } catch (SQLException ex){
            System.err.println("Erro ao buscar pelo id: "+ ex.getMessage());
        } finally{
            ConnectionManager.closeConnection(connection, statement, resultado);
        }
        return produto;
    }

    @Override
    public List<Produto> pesquisarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        List<Produto> produtos = new ArrayList();
        try {
            connection = ConnectionManager.openConnection();
            String sql = "SELECT * FROM produto ORDER BY nome ASC";
            statement = connection.prepareStatement(sql);
            resultado = statement.executeQuery();
            while (resultado.next()){
                Produto produto = new Produto();
                produto.setId(resultado.getLong("id"));
                produto.setNome(resultado.getString("nome"));
                produto.setPreco(resultado.getDouble("preco"));
                produto.setDataVencimento(resultado.getDate("vencimento").toLocalDate());
                produtos.add(produto);
            }
        } catch (SQLException ex){
            System.err.println("Erro ao buscar produtos: "+ ex.getMessage());
            throw new Exception(ex);
        } finally{
            ConnectionManager.closeConnection(connection, statement, resultado);
        }
        return produtos;
    
    }

    @Override
    public Produto atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        try {
            connection = ConnectionManager.openConnection();
            String sql = "UPDATE produto SET nome = ?, preco = ?, vencimento = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setDate(3, Date.valueOf(produto.getDataVencimento()));
            statement.setLong(4, produto.getId());
            statement.executeUpdate();
        } catch (SQLException ex){
            System.err.println("Erro ao buscar pelo id: "+ ex.getMessage());
        } finally{
            ConnectionManager.closeConnection(connection, statement, resultado);
        }
        return produto;
    }

    @Override
    public void remover(long id) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        try {
            connection = ConnectionManager.openConnection();
            String sql = "DELETE from produto WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException ex){
            System.err.println("Erro ao buscar pelo id: "+ ex.getMessage());
        } finally{
            ConnectionManager.closeConnection(connection, statement, resultado);
        }
    }

    @Override
    public void removerRegistros() throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        try {
            connection = ConnectionManager.openConnection();
            String sql = "DELETE from produto";
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex){
            System.err.println("Erro ao buscar pelo id: "+ ex.getMessage());
        } finally{
            ConnectionManager.closeConnection(connection, statement, resultado);
        }
    }

    
    
}
