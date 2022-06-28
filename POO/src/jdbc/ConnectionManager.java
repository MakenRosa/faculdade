package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
     private static final String USUARIO_BD = "root";
    private static final String SENHA_BD = "Senac2021";
    private static final String NOME_BANCO = "senac";
    private static final String STR_TIMEZONE = "?useTimezone=true&serverTimezone=America/Sao_Paulo&"
            + "zeroDateTimeBehavior=convertToNull";
    private static final String STR_CON = "jdbc:mysql://localhost:3306/" + NOME_BANCO + STR_TIMEZONE;
    public static Connection abrirConexao() throws Exception{
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection(STR_CON, USUARIO_BD, SENHA_BD);
            System.out.println("Conectado ao banco!");
        } catch(SQLException e) {
            throw new Exception("Driver não encontrado: "+ e.getMessage(), e);
        }catch(Exception e){
            throw new Exception("Erro ao obter conexão: "+ e.getMessage(), e);
        }
        return conexao;
    }
    public static void fechar(Connection connection, Statement statement, ResultSet resultset) throws SQLException{
        if (connection != null){
            connection.close();
        }
        if (statement != null){
            statement.close();
        }
        if (resultset != null){
            resultset.close();
        }
    }
    public static void fechar(Connection connection, Statement statement ) throws SQLException{
        if (connection != null){
            connection.close();
        }
        if (statement != null){
            statement.close();
        }
    }
    public static void fechar(Connection connection) throws SQLException{
        if (connection != null){
            connection.close();
        }
    }
}
