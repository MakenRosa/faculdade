/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Perfil;
import static br.com.senac.util.Gerador.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maken.Rosa
 */
public class PerfilDAOImplTest {

    private Perfil perfil;
    private final PerfilDAO perfilDAO;
    private Session sessao;

    public PerfilDAOImplTest() {
        perfilDAO = new PerfilDAOImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        perfil = new Perfil(gerarNome(), gerarSenha(20));
        sessao = HibernateUtil.abrirConexao();
        perfilDAO.salvarOuAlterar(perfil, sessao);
        sessao.close();
        assertNotNull(perfil.getId());
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarPerfilBd();
        sessao = HibernateUtil.abrirConexao();
        perfilDAO.excluir(perfil, sessao);
        Perfil perfilExc = perfilDAO.pesquisarPorId(perfil.getId(), sessao);
        sessao.close();
        assertNull(perfilExc);
    }
    
//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarPerfilBd();
        perfil.setNome(gerarNome());
        sessao = HibernateUtil.abrirConexao();
        perfilDAO.salvarOuAlterar(perfil, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        Perfil perfilPesq = perfilDAO.pesquisarPorId(perfil.getId(), sessao);
        sessao.close();
        assertEquals(perfilPesq.getNome(), perfil.getNome());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarPerfilBd();
        sessao = HibernateUtil.abrirConexao();
        Perfil perfilPesq = perfilDAO.pesquisarPorId(perfil.getId(), sessao);
        sessao.close();
        assertNotNull(perfilPesq);
    }


//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarPerfilBd();
        sessao = HibernateUtil.abrirConexao();
        List<Perfil> perfis = perfilDAO.pesquisarPorNome(perfil.getNome(), sessao);
        sessao.close();
        assertTrue(perfis.size() > 0);
    }

//    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        sessao = HibernateUtil.abrirConexao();
        List<Perfil> perfis = perfilDAO.pesquisarTodos(sessao);
        sessao.close();
        assertTrue(!perfis.isEmpty());
    }

    public Perfil buscarPerfilBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Perfil> consulta = sessao
                .createQuery("from Perfil p"); //HQL
        List<Perfil> usuarios = consulta.getResultList();
        sessao.close();
        if (usuarios.isEmpty()) {
            testSalvar();
        } else {
            perfil = usuarios.get(0);
        }
        return perfil;
    }

}
