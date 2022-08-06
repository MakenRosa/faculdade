/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Gerador;

/**
 *
 * @author maken.rosa
 */
public class UsuarioDAOImplTest {
    
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;
    
    public UsuarioDAOImplTest() {
        usuarioDAO = new UsuarioDAOImpl();
    }

    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        Usuario usuario = new Usuario(Gerador.gerarNome(), 
                Gerador.gerarLogin(), 
                Gerador.gerarSenha(8));
    }

    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Usuario usuario = null;
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        instance.alterar(usuario);
        fail("The test case is a prototype.");
    }

    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Integer id = null;
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        instance.excluir(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        Integer id = null;
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        Usuario expResult = null;
        Usuario result = instance.pesquisarPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPesquisarTodos() throws Exception {
        System.out.println("pesquisarTodos");
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.pesquisarTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("PesquisarPorNome");
        String nome = "";
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.PesquisarPorNome(nome);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
