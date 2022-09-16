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
    public void testSalvar(){
        System.out.println("salvar");
        perfil = new Perfil(gerarSenha(7), "Lorem ipsum dolor siamet");
        sessao = HibernateUtil.abrirConexao();
        perfilDAO.salvarOuAlterar(perfil, sessao);
        sessao.close();
        assertNotNull(this.perfil.getId());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        Long id = null;
        Session sessao = null;
        PerfilDAOImpl instance = new PerfilDAOImpl();
        Perfil expResult = null;
        Perfil result = instance.pesquisarPorId(id, sessao);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        String nome = "";
        Session sessao = null;
        PerfilDAOImpl instance = new PerfilDAOImpl();
        List<Perfil> expResult = null;
        List<Perfil> result = instance.pesquisarPorNome(nome, sessao);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        sessao = HibernateUtil.abrirConexao();
        List<Perfil> perfis = perfilDAO.pesquisarTodos(sessao);
        sessao.close();
        assertFalse(perfis.isEmpty());
    }
    
        public Perfil buscarPerfilBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Perfil> consulta = sessao
                .createQuery("from Usuario u"); //HQL
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
