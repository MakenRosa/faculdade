/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import util.Gerador;

/**
 *
 * @author maken.rosa
 */
public class UsuarioDAOImplTest {
    
    private Usuario usuario;
    private final UsuarioDAO usuarioDAO;
    
    public UsuarioDAOImplTest() {
        usuarioDAO = new UsuarioDAOImpl();
    }

//    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        usuario = new Usuario(
                Gerador.gerarNome(), 
                Gerador.gerarLogin(), 
                Gerador.gerarSenha(8));
        usuarioDAO.salvar(usuario);
        assertNotNull(usuario.getId());
    }

//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        usuario = pesquisarUsuarioBD();
        usuario.setNome(Gerador.gerarNome());
        usuarioDAO.alterar(usuario);
    }

//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        usuarioDAO.excluir(2);
    }

//    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisar por id!");
        usuario = usuarioDAO.pesquisarPorId(67);
        System.out.println(usuario.getNome());
        assertNotNull(usuario.getId());
    }

//    @Test
    public void testPesquisarTodos() throws Exception {
        System.out.println("pesquisarTodos");
        List<Usuario> usuarios = usuarioDAO.pesquisarTodos();
        for (Usuario usuario1 : usuarios) {
            System.out.println(usuario1.getNome());
        }
    }

    @Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("PesquisarPorNome");
        List<Usuario> usuarios = usuarioDAO.PesquisarPorNome(Gerador.gerarNome());
        for (Usuario usuario1 : usuarios) {
            System.out.println(usuario1.getNome());
        }
    }
    private Usuario pesquisarUsuarioBD() throws Exception {
        String sql = "SELECT * FROM usuario LIMIT 1";
        Connection conexao = FabricaConexao.abrirConexao();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        ResultSet res = pstm.executeQuery();
        if (res.next()){
            Usuario user = new Usuario(res.getString("nome"),
                    res.getString("login"),
                    res.getString("senha"));
            user.setId(res.getInt("id_usuario"));
            return user;
        } else{
            testSalvar();
        }
        return null;
    }
}
