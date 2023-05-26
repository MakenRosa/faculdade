/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author maken.rosa
 */
public class ProdutoDAOImplTest {
    ProdutoDAO produtoDAO;
    Produto produto;
    Session sessao;
    
    public ProdutoDAOImplTest() {
        produtoDAO = new ProdutoDAOImpl();
    }
//    @Test
    public void testSalvar(){
        System.out.println("salvar");
        produto = new Produto(Gerador.gerarNome(), (String) Gerador.gerarCep()+Gerador.gerarCidade(), 
                Integer.valueOf(Gerador.gerarNumero(2)), Double.valueOf(Gerador.gerarNumero(4)));
        sessao = HibernateUtil.abrirConexao();
        produtoDAO.salvarOuAlterar(produto, sessao);
        sessao.close();
        assertNotNull(produto.getId());
        
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        pesquisarProdutoBd();
        sessao = HibernateUtil.abrirConexao();
        Produto produtoPesquisado = produtoDAO.pesquisarPorId(produto.getId(), sessao);
        assertEquals(produtoPesquisado, produto);
        sessao.close();
    }
    
//    @Test
    public void testAlterar(){
        System.out.println("alterar");
        pesquisarProdutoBd();
        produto.setNome(Gerador.gerarNome());
        sessao = HibernateUtil.abrirConexao();
        produtoDAO.salvarOuAlterar(produto, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        Produto produtoPesquisado = produtoDAO.pesquisarPorId(produto.getId(), sessao);
        sessao.close();
        assertEquals(produto.getNome(), produtoPesquisado.getNome());
    }
    
//    @Test
    public void testExcluir(){
        System.out.println("excluir");
        pesquisarProdutoBd();
        sessao = HibernateUtil.abrirConexao();
        produtoDAO.excluir(produto, sessao); 
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        produto = produtoDAO.pesquisarPorId(produto.getId(), sessao);
        sessao.close();
        assertNull(produto);
    }
    @Test
    public void testPesquisarPorNome(){
        System.out.println("pesquisarPorNome");
        pesquisarProdutoBd();
        List<Produto> produtos = produtoDAO.pesquisarPorNome(produto.getNome(), sessao);
        assertNotNull(produtos);
    }
    public Produto pesquisarProdutoBd(){
        sessao = HibernateUtil.abrirConexao();
        Query<Produto> consulta = sessao.createQuery("from Produto p");
        List<Produto> produtos = consulta.getResultList();
        sessao.close();
        if (produtos.isEmpty()){
            testSalvar();
        } else{
            produto = produtos.get(0);
        }
        return produto;
    }
    
}
