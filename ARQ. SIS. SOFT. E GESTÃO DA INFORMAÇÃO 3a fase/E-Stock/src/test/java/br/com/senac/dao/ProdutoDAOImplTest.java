/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Produto;
import br.com.senac.util.Gerador;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maken.Rosa
 */
public class ProdutoDAOImplTest {
    private final ProdutoDAO produtoDAO;
    private Produto produto;
    private Session sessao;
    
    public ProdutoDAOImplTest() {
        produtoDAO = new ProdutoDAOImpl();
    }
    @Test
    public void testSalvar(){
        List<String> produtoList= Gerador.gerarProduto();
        System.out.println("salvar");
        produto = new Produto (produtoList.get(0), produtoList.get(1));
        sessao = HibernateUtil.abrirConexao();
        produtoDAO.salvarOuAlterar(produto, sessao);
        sessao.close();
        assertNotNull(produto.getIdProduto());
    }
//    @Test
    public void testAlterar(){
        System.out.println("alterar");
        buscarProdutoBd();
        List<String> produts = Gerador.gerarProduto();
        produto.setNome(produts.get(0));
        produto.setDescricao(produts.get(1));
        sessao = HibernateUtil.abrirConexao();
        produtoDAO.salvarOuAlterar(produto, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        Produto produtoPesquisado = produtoDAO.pesquisarPorId(produto.getIdProduto(), sessao);
        sessao.close();
        assertEquals(produto.getNome(), produtoPesquisado.getNome());
        assertEquals(produto.getDescricao(), produtoPesquisado.getDescricao());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarProdutoBd();
        sessao = HibernateUtil.abrirConexao();
        Produto produtoPesquisado = produtoDAO.pesquisarPorId(produto.getIdProduto(), sessao);
        sessao.close();
        System.out.println(produtoPesquisado.getNome());
        assertNotNull(produtoPesquisado);
    }
    
//    @Test
    public void testExcluir(){
        System.out.println("excluir");
        buscarProdutoBd();
        sessao = HibernateUtil.abrirConexao();
        produtoDAO.excluir(produto, sessao);
        Produto produtoExcluido = produtoDAO.pesquisarPorId(produto.getIdProduto(), sessao);
        sessao.close();
        assertNull(produtoExcluido);
    }
    
    private Produto buscarProdutoBd(){
        sessao = HibernateUtil.abrirConexao();
        Query<Produto> consulta = sessao.createQuery("from Produto p");
        consulta.setMaxResults(1);
        produto = consulta.getSingleResult();
        sessao.close();
        if (produto == null){
            testSalvar();
        } 
        return produto;
    }
}
