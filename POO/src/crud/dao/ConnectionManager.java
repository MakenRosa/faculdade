package crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class ConnectionManager {
     private static final String USUARIO_BD = "root";
    private static final String SENHA_BD = "Senac2021";
    private static final String NOME_BANCO = "senac";
    private static final String STR_TIMEZONE = "?useTimezone=true&serverTimezone=America/Sao_Paulo&"
            + "zeroDateTimeBehavior=convertToNull";
    private static final String STR_CON = "jdbc:mysql://localhost:3306/" + NOME_BANCO + STR_TIMEZONE;
    public static Connection openConnection() throws SQLException{
        return DriverManager.getConnection(STR_CON, USUARIO_BD, SENHA_BD);
    }
    
    public static void closeConnection(Connection connection) throws SQLException{
        closeConnection(connection, null, null);
    }
    public static void closeConnection(Connection connection, Statement statement) throws SQLException{
        closeConnection(connection, statement, null);
    }
    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws SQLException{
        if (Objects.nonNull(connection)){
            connection.close();
        }
        if (Objects.nonNull(statement)){
            statement.close();
        }
        if (Objects.nonNull(resultSet)){
            resultSet.close();
        }
    }
    
}
