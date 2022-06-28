package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProdutoDAO {
    public Produto criar(Produto produto) throws Exception{
        String sql = "INSERT INTO produto(nome, preco, vencimento) VALUES(?, ?, ?)";
        Connection conexao = null;
        PreparedStatement prepararSql = null;
        ResultSet resultado = null;
        try {
            conexao = ConnectionManager.abrirConexao();
            prepararSql = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepararSql.setString(1, produto.getNome());
            prepararSql.setDouble(2, produto.getPreco());
            prepararSql.setDate(3, Date.valueOf(produto.getDataVencimento()));
            prepararSql.executeUpdate();
            resultado = prepararSql.getGeneratedKeys();
            resultado.next();
            produto.setId(resultado.getLong("id"));
            
        } catch (Exception ex){
            System.err.println("Erro ao adicionar valores");
            throw new Exception(ex);
        } finally {
            ConnectionManager.fechar(conexao, prepararSql, resultado);
        }
        return null;
    }
    public Produto buscarPeloId(long id){
        return null;
    }
    public void criarTabela() throws Exception{
        String sql = getSqlCriarTabela();
        Connection conexao = null;
        Statement statement = null;
        try{
            conexao = ConnectionManager.abrirConexao();
            statement = conexao.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex){
            System.err.println("Erro ao criar tabela: "+ ex.getMessage());
            throw new Exception(ex);
        } finally {
            ConnectionManager.fechar(conexao, statement);
            System.out.println("Conexão fechada!");
        }
    }
private String getSqlCriarTabela() {
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
}
