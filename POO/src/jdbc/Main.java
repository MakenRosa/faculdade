package jdbc;

public class Main {
    public static void main(String[] args) {
        try {
            ProdutoDAO produto = new ProdutoDAO();
            produto.criarTabela();
        } catch (Exception ex) {
            System.err.println("Erro ao criar banco de dados: " + ex.getMessage());
        }
    }
}
