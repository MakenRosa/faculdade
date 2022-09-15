/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.com.senac.tela;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.ItemEntradaDAO;
import br.com.senac.dao.ItemEntradaDAOImpl;
import br.com.senac.dao.ProdutoDAO;
import br.com.senac.dao.ProdutoDAOImpl;
import br.com.senac.entidade.ItemEntrada;
import br.com.senac.entidade.Produto;
import java.time.LocalDate;
import java.util.List;
import net.bytebuddy.asm.Advice;
import org.hibernate.Session;

/**
 *
 * @author Truen
 */
public class Main {

    /**
     * @param de
     * @param ate
     */
    public static void gerarRelatorioEntrada(LocalDate de, LocalDate ate){
        ItemEntradaDAO itemEntradaDAO = new ItemEntradaDAOImpl();
        Session sessao = HibernateUtil.abrirConexao();
        List<Produto> produtos = itemEntradaDAO.gerarRelatorioEntrada(de, ate, sessao);
        for (Produto produto : produtos) {
            System.out.println(produto.getNome());
        }
    }
    public static void main(String[] args) {
        gerarRelatorioEntrada(LocalDate.of(2022, 9, 1), LocalDate.of(2022, 9, 30));
    }
}
