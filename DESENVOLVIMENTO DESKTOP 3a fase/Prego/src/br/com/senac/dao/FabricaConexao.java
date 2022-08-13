package br.com.senac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class FabricaConexao {
    public static Connection abrirConexao() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/prego?useTimezone=true&serverTimezone=UTC", "root", "Senac2021");  
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao abrir conexão! " + ex.getMessage());
        }
        return null;
    }
    public static void fecharConexao(Connection conexao, Statement statement, ResultSet resultSet) throws SQLException{
        if (Objects.nonNull(conexao)){
            conexao.close();
        } if (Objects.nonNull(statement)){
            statement.close();
        } if (Objects.nonNull(resultSet));
    }
    
}
