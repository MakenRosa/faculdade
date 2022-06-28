package jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class ProdutoDAO {
    public Produto criar(Produto produto){
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
