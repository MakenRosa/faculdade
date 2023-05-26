/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.*;
import java.time.LocalDate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;
import static br.com.senac.util.Gerador.*;

/**
 *
 * @author Maken.Rosa
 */
public class ItemSaidaDAOImplTest {

    private final ItemSaidaDAO itemDAO;
    private ItemSaida item;
    private Session sessao;

    public ItemSaidaDAOImplTest() {
        itemDAO = new ItemSaidaDAOImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        ProdutoDAOImplTest pdit = new ProdutoDAOImplTest();
        ClienteDAOImplTest cdit = new ClienteDAOImplTest();
        ItemEntradaDAOImplTest iedit = new ItemEntradaDAOImplTest();
        sessao = HibernateUtil.abrirConexao();
        Produto produto = pdit.buscarProdutoBd();
        Cliente cliente = cdit.buscarClienteBd();
        ItemEntrada itemEntrada = iedit.buscarItemEntradaBd();
        sessao.close();
        String preco = gerarNumero(2) + "." + gerarNumero(2);
        item = new ItemSaida(produto,
                cliente, LocalDate.now(), Integer.valueOf(gerarNumero(1)),
                itemEntrada.getLote(), Double.valueOf(preco));
        sessao = HibernateUtil.abrirConexao();
        itemDAO.salvarOuAlterar(item, sessao);
        sessao.close();
        assertNotNull(produto.getIdProduto());
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarItemSaidaBd();
        item.setQtdProduto(item.getQtdProduto() - 1);
        sessao = HibernateUtil.abrirConexao();
        itemDAO.salvarOuAlterar(item, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        ItemSaida itemPesquisado = itemDAO.pesquisarPorId(item.getIdItemSaida(), sessao);
        sessao.close();
        assertEquals(item.getIdItemSaida(), itemPesquisado.getIdItemSaida());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarItemSaidaBd();
        sessao = HibernateUtil.abrirConexao();
        ItemSaida itemPesquisado = itemDAO.pesquisarPorId(item.getIdItemSaida(), sessao);
        sessao.close();
        System.out.println(itemPesquisado.getLote());
        assertNotNull(itemPesquisado);
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarItemSaidaBd();
        sessao = HibernateUtil.abrirConexao();
        itemDAO.excluir(item, sessao);
        ItemSaida itemExcluido = itemDAO.pesquisarPorId(item.getIdItemSaida(), sessao);
        sessao.close();
        assertNull(itemExcluido);
    }

    public void buscarItemSaidaBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<ItemSaida> consulta = sessao.createQuery("from ItemSaida i");
        consulta.setMaxResults(1);
        item = consulta.getSingleResult();
        sessao.close();
        if (item == null) {
            testSalvar();
        }
    }
}
