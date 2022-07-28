package crud.entidades;

import crud.dao.ProdutoDAO;
import crud.dao.impl.ProdutoDAOImpl;

public class Principal {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAOImpl();
        try {
            
        } catch (Exception ex) {
            System.err.println("Erro na main: "+ ex.getMessage());
        }
    }
}
