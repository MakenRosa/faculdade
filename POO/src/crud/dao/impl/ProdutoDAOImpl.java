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
            resultado.next();
            produto.setId(resultado.getLong(1));
        } catch (SQLException ex){
            System.err.println("Erro ao criar produto! " + ex.getMessage());
        } finally {
            crud.dao.ConnectionManager.closeConnection(connection, statement);
        }
        return produto;
    }

    @Override
    public Produto buscarPeloId(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> pesquisarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto atualizar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
