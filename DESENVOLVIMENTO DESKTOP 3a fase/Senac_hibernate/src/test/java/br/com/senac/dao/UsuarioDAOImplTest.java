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
 * @author silvio.junior
 */
public class UsuarioDaoImplTest {

    private Usuario usuario;
    private final UsuarioDAO usuarioDAO;
    private Session sessao;

    public UsuarioDaoImplTest() {
        usuarioDAO = new UsuarioDAOImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        PerfilDAOImplTest pdit = new PerfilDAOImplTest();
        usuario = new Usuario(gerarNome(), (gerarLogin() + gerarSenha(4)),
                gerarSenha(8));
        usuario.setPerfil(pdit.buscarPerfilBd());
        sessao = HibernateUtil.abrirConexao();
        usuarioDAO.salvarOuAlterar(usuario, sessao);
        sessao.close();
        assertNotNull(usuario.getId());
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        usuarioDAO.excluir(usuario, sessao);
        Usuario usuExc = usuarioDAO
                .pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertNull(usuExc);
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarUsuarioBd();
        usuario.setNome(gerarNome());
        sessao = HibernateUtil.abrirConexao();
        usuarioDAO.salvarOuAlterar(usuario, sessao);
        sessao.close();

        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioPesq = usuarioDAO
                .pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertEquals(usuarioPesq.getNome(), usuario.getNome());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioPesq = usuarioDAO
                .pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertNotNull(usuarioPesq);
    }


//    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        sessao = HibernateUtil.abrirConexao();
        List<Usuario> usuarios = usuarioDAO
                .pesquisarTodos(sessao);
        sessao.close();
        mostrar(usuarios);
        assertTrue(!usuarios.isEmpty());
    }

    private void mostrar(List<Usuario> usuarios) {

        usuarios.stream()
                .forEach(usu -> {
                    System.out.println("ID " + usu.getId());
                    System.out.println("Nome " + usu.getNome());
                    System.out.println("Login " + usu.getLogin());
                    System.out.println("Senha " + usu.getSenha());
                    System.out.println("");
                });
    }

//    private void mostrarSorted(List<Usuario> usuarios) {
//        usuarios.stream()
//                .sorted((usu1, us2)
//                        -> usu1.getNome().compareTo(us2.getNome()))
//                .forEach(usu -> {
//                    System.out.println("ID " + usu.getId());
//                    System.out.println("Nome " + usu.getNome());
//                    System.out.println("Login " + usu.getLogin());
//                    System.out.println("Senha " + usu.getSenha());
//                    System.out.println("");
//                });
//    }

//    @Test
    public void testLogar() {
        System.out.println("logar");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioLogado = usuarioDAO
                .logar(usuario.getLogin(), usuario.getSenha(), sessao);
        sessao.close();
        assertNotNull(usuarioLogado);

    }

    public Usuario buscarUsuarioBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Usuario> consulta = sessao
                .createQuery("from Usuario u"); //HQL
        List<Usuario> usuarios = consulta.getResultList();
        sessao.close();
        if (usuarios.isEmpty()) {
            testSalvar();
        } else {
            usuario = usuarios.get(0);
        }
        return usuario;
    }

}
