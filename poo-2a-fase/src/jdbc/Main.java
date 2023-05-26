package jdbc;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            ProdutoDAO produto = new ProdutoDAO();
            
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
    }
}
