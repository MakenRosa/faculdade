/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemEntrada;
import br.com.senac.entidade.Produto;
import br.com.senac.util.Gerador;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maken.Rosa
 */
public class ItemEntradaDAOImplTest {

    private final ItemEntradaDAO itemDAO;
    private ItemEntrada item;
    private Session sessao;

    public ItemEntradaDAOImplTest() {
        itemDAO = new ItemEntradaDAOImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        ProdutoDAOImplTest pdit = new ProdutoDAOImplTest();
        sessao = HibernateUtil.abrirConexao();
        Produto produto = pdit.buscarProdutoBd();
        sessao.close();
        item = new ItemEntrada(produto,
                LocalDate.now(),
                Integer.valueOf(Gerador.gerarNumero(2)),
                LocalDate.now(),
                Gerador.gerarSenha(6),
                Double.valueOf(Gerador.gerarNumero(3)));
        sessao = HibernateUtil.abrirConexao();
        itemDAO.salvarOuAlterar(item, sessao);
        sessao.close();
        assertNotNull(produto.getIdProduto());
    }
    
//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarItemEntradaBd();
        item.setQtdProduto(Integer.valueOf(Gerador.gerarNumero(2)));
        sessao = HibernateUtil.abrirConexao();
        itemDAO.salvarOuAlterar(item, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        ItemEntrada itemPesquisado = itemDAO.pesquisarPorId(item.getIdItemEntrada(), sessao);
        sessao.close();
        assertEquals(item.getIdItemEntrada(), itemPesquisado.getIdItemEntrada());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarItemEntradaBd();
        sessao = HibernateUtil.abrirConexao();
        ItemEntrada itemPesquisado = itemDAO.pesquisarPorId(item.getIdItemEntrada(), sessao);
        sessao.close();
        System.out.println(itemPesquisado.getLote());
        assertNotNull(itemPesquisado);
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarItemEntradaBd();
        sessao = HibernateUtil.abrirConexao();
        itemDAO.excluir(item, sessao);
        ItemEntrada itemExcluido = itemDAO.pesquisarPorId(item.getIdItemEntrada(), sessao);
        sessao.close();
        assertNull(itemExcluido);
    }

    public ItemEntrada buscarItemEntradaBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<ItemEntrada> consulta = sessao.createQuery("from ItemEntrada ie");
        consulta.setMaxResults(1);
        item = consulta.getSingleResult();
        sessao.close();
        if (item == null) {
            testSalvar();
        }
        return item;
    }
}
