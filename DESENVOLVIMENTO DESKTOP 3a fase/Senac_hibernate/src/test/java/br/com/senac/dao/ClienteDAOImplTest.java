/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
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
public class ClienteDAOImplTest {
    Cliente cliente;
    ClienteDAO clienteDAO;
    Session sessao;
    
    public ClienteDAOImplTest() {
        clienteDAO = new ClienteDAOImpl();
    }
//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        ProfissaoDAOImplTest pdit = new ProfissaoDAOImplTest();
        cliente = new Cliente(gerarNome(), gerarCpf(), 
                gerarNumero(9), Double.valueOf(gerarNumero(4)));
        cliente.setProfissao(pdit.buscarProfissaoBd());
        sessao = HibernateUtil.abrirConexao();
        clienteDAO.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        clienteDAO.excluir(cliente, sessao);
        Cliente clienteExc = clienteDAO
                .pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        assertNull(clienteExc);
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarClienteBd();
        cliente.setNome(gerarNome());
        sessao = HibernateUtil.abrirConexao();
        clienteDAO.salvarOuAlterar(cliente, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        Cliente clientePesq = clienteDAO.pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        assertEquals(clientePesq.getNome(), cliente.getNome());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        Cliente clientePesq = clienteDAO
                .pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        assertNotNull(clientePesq);
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        List<Cliente> usuarios = clienteDAO.pesquisarPorNome(cliente.getNome(), sessao);
        sessao.close();
        assertTrue(!usuarios.isEmpty());
    }

//    @Test
    public void testPesquisarTodos() {
        System.out.println("pesquisarTodos");
        sessao = HibernateUtil.abrirConexao();
        List<Cliente> clientes = clienteDAO.pesquisarTodos(sessao);
        sessao.close();
        assertTrue(!clientes.isEmpty());
    }
    
    public Cliente buscarClienteBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Cliente> consulta = sessao
                .createQuery("from Cliente c"); //HQL
        List<Cliente> clientes = consulta.getResultList();
        sessao.close();
        if (clientes.isEmpty()) {
            testSalvar();
        } else {
            cliente = clientes.get(0);
        }
        return cliente;
    }
    
}
