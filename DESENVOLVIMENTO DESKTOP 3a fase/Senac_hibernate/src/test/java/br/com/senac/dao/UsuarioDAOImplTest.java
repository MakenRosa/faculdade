/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import static br.com.senac.util.Gerador.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maken.rosa
 */
public class UsuarioDAOImplTest {
    private Usuario usuario;
    private final UsuarioDAO usuarioDAO;
    private Session sessao;
    
    public UsuarioDAOImplTest() {
        usuarioDAO = new UsuarioDAOImpl();
    }
//    @Test
    public void testSalvar(){
        System.out.println("salvar");
        usuario = new Usuario(gerarNome(), gerarLogin(), gerarSenha(7));
        sessao = HibernateUtil.abrirConexao();
        usuarioDAO.salvarOuAlterar(this.usuario, this.sessao);
        sessao.close();
        assertNotNull(usuario.getId());
    }
//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioPesquisado = usuarioDAO.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        System.out.println(usuarioPesquisado.getNome());
        assertNotNull(usuarioPesquisado);
    }
//    @Test
    public void testExcluir(){
        System.out.println("excluir");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        usuarioDAO.excluir(usuario, sessao);
        Usuario usuarioExcluido = usuarioDAO.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertNull(usuarioExcluido);
    }
    @Test
    public void testAlterar(){
        System.out.println("alterar");
        buscarUsuarioBd();
        usuario.setNome(gerarNome());
        sessao = HibernateUtil.abrirConexao();
        usuarioDAO.salvarOuAlterar(usuario, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioPesquisado = usuarioDAO.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertEquals(usuario.getNome(), usuarioPesquisado.getNome());
    }
    
    public Usuario buscarUsuarioBd(){
        sessao = HibernateUtil.abrirConexao();
        Query<Usuario> consulta = sessao.createQuery("from Usuario u"); //HQL
        List<Usuario> usuarios = consulta.getResultList();
        sessao.close();
        if (usuarios.isEmpty()){
            testSalvar();
        } else{
            usuario = usuarios.get(0);
        }
        return usuario;
    }
}
