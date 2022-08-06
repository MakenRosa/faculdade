package br.com.senac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
}
