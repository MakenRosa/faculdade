package crud.entidades;

import crud.dao.ProdutoDAO;
import crud.dao.impl.ProdutoDAOImpl;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAOImpl();
        Produto produto = new Produto("Chocolate", 6, LocalDate.of(2022, Month.DECEMBER, 25));
        try {
            produto = produtoDAO.criar(produto);
            System.out.println("criou! id: "+ produto.getId());
        } catch (Exception ex) {
            System.err.println("Não foi possível adicionar dados na tabela! "+ ex.getMessage());
        }
    }
}
