/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.com.senac.main;

import br.com.senac.dao.ItemEntradaDAO;
import br.com.senac.dao.ItemEntradaDAOImpl;
import br.com.senac.dao.ItemSaidaDAO;
import br.com.senac.dao.ItemSaidaDAOImpl;
import br.com.senac.dao.ProdutoDAO;
import br.com.senac.dao.ProdutoDAOImpl;

/**
 *
 * @author Maken.Rosa
 */
public class Main {

    public static void main(String[] args) {
        ItemEntradaDAO entradaDAO = new ItemEntradaDAOImpl();
        ItemSaidaDAO saidaDAO = new ItemSaidaDAOImpl();
        ProdutoDAO produtoDAO = new ProdutoDAOImpl();
        entradaDAO.gerarRelatorioEntrada("10/09/2022", "30/09/2022");
        saidaDAO.gerarRelatorioSaida("10/09/2022", "30/09/2022");
        produtoDAO.verProdutosDisponiveis();
    }
}
