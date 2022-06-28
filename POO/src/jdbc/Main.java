package jdbc;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            ProdutoDAO produto = new ProdutoDAO();
            produto.criarTabela();
            Produto pera = new Produto("Pêra", 5.50, LocalDate.now());
            produto.criar(pera);
        } catch (Exception ex) {
            System.err.println("Erro ao criar banco de dados: " + ex.getMessage());
        }
    }
}
