package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
