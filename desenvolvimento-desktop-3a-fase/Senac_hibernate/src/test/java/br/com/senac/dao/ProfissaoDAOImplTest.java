/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Profissao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import static org.junit.Assert.*;
import static br.com.senac.util.Gerador.*;

/**
 *
 * @author maken.rosa
 */
public class ProfissaoDAOImplTest {

    Profissao profissao;
    ProfissaoDAO profissaoDAO;
    Session sessao;

    public ProfissaoDAOImplTest() {
        profissaoDAO = new ProfissaoDAOImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        profissao = new Profissao(gerarProfissao(), gerarSenha(10));
        sessao = HibernateUtil.abrirConexao();
        profissaoDAO.salvarOuAlterar(profissao, sessao);
        sessao.close();
        assertNotNull(profissao.getId());
    }

//        @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarProfissaoBd();
        sessao = HibernateUtil.abrirConexao();
        profissaoDAO.excluir(profissao, sessao);
        Profissao profissaoExc = profissaoDAO.pesquisarPorId(profissao.getId(), sessao);
        sessao.close();
        assertNull(profissaoExc);
    }
    
//        @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarProfissaoBd();
        profissao.setNome(gerarProfissao());
        sessao = HibernateUtil.abrirConexao();
        profissaoDAO.salvarOuAlterar(profissao, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        Profissao profissaoPesq = profissaoDAO.pesquisarPorId(profissao.getId(), sessao);
        sessao.close();
        assertEquals(profissaoPesq.getNome(), profissao.getNome());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarProfissaoBd();
        sessao = HibernateUtil.abrirConexao();
        Profissao profissaoPesq = profissaoDAO.pesquisarPorId(profissao.getId(), sessao);
        sessao.close();
        assertNotNull(profissaoPesq);
    }

//    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        sessao = HibernateUtil.abrirConexao();
        List<Profissao> usuarios = profissaoDAO.pesquisarTodos(sessao);
        sessao.close();
        assertFalse(usuarios.isEmpty());
    }

    public Profissao buscarProfissaoBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Profissao> consulta = sessao.createQuery("FROM Profissao p");
        consulta.setMaxResults(1);
        profissao = consulta.getSingleResult();
        if (profissao == null) {
            testSalvar();
        }
        return profissao;
    }
}
