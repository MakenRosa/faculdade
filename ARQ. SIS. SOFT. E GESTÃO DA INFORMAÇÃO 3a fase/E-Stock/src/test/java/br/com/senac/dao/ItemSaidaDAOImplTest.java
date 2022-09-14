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

/**
 *
 * @author Truen
 */
public class ItemSaidaDAOImplTest {
    private final ItemSaidaDAO itemDAO;
    private final ProdutoDAO produtoDAO;
    private final ClienteDAO clienteDAO;
    private final ItemEntradaDAO entradaDAO;
    private ItemSaida item;
    private Session sessao;

    public ItemSaidaDAOImplTest() {
        itemDAO = new ItemSaidaDAOImpl();
        produtoDAO = new ProdutoDAOImpl();
        clienteDAO = new ClienteDAOImpl();
        entradaDAO = new ItemEntradaDAOImpl();
    }
    
    @Test
    public void testSalvar(){
        System.out.println("salvar");
        sessao = HibernateUtil.abrirConexao();
        Produto produto = buscarProdutoBd(sessao);
        Cliente cliente = gerarClienteBd(sessao);
        ItemEntrada itemEntrada = gerarItemEntradaBd(sessao);
        sessao.close();
        item = new ItemSaida(produto, 
                cliente, LocalDate.now(), itemEntrada.getQtdProduto()-1, 
                itemEntrada.getLote(), 
                (itemEntrada.getPreco()-(itemEntrada.getPreco()/itemEntrada.getQtdProduto())));
        sessao = HibernateUtil.abrirConexao();
        itemDAO.salvarOuAlterar(item, sessao);
        sessao.close();
        assertNotNull(produto.getIdProduto());
    }
    
////    @Test
//    public void testAlterar(){
//        System.out.println("alterar");
//        gerarItemEntradaBd();
//        item.setQtdProduto(Integer.valueOf(gerarNumero(1)));
//        sessao = HibernateUtil.abrirConexao();
//        itemDAO.salvarOuAlterar(item, sessao);
//        sessao.close();
//        sessao = HibernateUtil.abrirConexao();
//        ItemEntrada itemPesquisado = itemDAO.pesquisarPorId(item.getIdItemEntrada(), sessao);
//        sessao.close();
//        assertEquals(item.getIdItemEntrada(), itemPesquisado.getIdItemEntrada());
//    }
//
////    @Test
//    public void testPesquisarPorId() {
//        System.out.println("pesquisarPorId");
//        gerarItemEntradaBd();
//        sessao = HibernateUtil.abrirConexao();
//        ItemEntrada itemPesquisado = itemDAO.pesquisarPorId(item.getIdItemEntrada(), sessao);
//        sessao.close();
//        System.out.println(itemPesquisado.getLote());
//        assertNotNull(itemPesquisado);
//    }
//    
////    @Test
//    public void testExcluir(){
//        System.out.println("excluir");
//        gerarItemEntradaBd();
//        sessao = HibernateUtil.abrirConexao();
//        itemDAO.excluir(item, sessao);
//        ItemEntrada itemExcluido = itemDAO.pesquisarPorId(item.getIdItemEntrada(), sessao);
//        sessao.close();
//        assertNull(itemExcluido);
//    }
//    public void gerarItemEntradaBd(){
//        sessao = HibernateUtil.abrirConexao();
//        Query<ItemSaida> consulta = sessao.createQuery("from ItemSaida i");
//        consulta.setMaxResults(1);
//        item = consulta.getSingleResult();
//        sessao.close();
//        if (item == null){
//            testSalvar();
//        }
//    }
    public Produto buscarProdutoBd(Session sessao) throws HibernateException{
        Query<Produto> consulta = sessao.createQuery("from Produto p");
        consulta.setMaxResults(1);
        Produto produto = consulta.getSingleResult();
        return produto;
    }
    public Cliente gerarClienteBd(Session sessao) throws HibernateException{
        Query<Cliente> consulta = sessao.createQuery("from Cliente c");
        consulta.setMaxResults(1);
        Cliente cliente = consulta.getSingleResult();
        return cliente;
    }
    public ItemEntrada gerarItemEntradaBd(Session sessao) throws HibernateException{
    Query<ItemEntrada> consulta = sessao.createQuery("from ItemEntrada ie");
    consulta.setMaxResults(1);
    return consulta.getSingleResult();
     
    }
}
