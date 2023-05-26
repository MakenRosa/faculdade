/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.util.Gerador;
import static br.com.senac.util.Gerador.gerarNome;
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
    ClienteDAO clienteDAO;
    Cliente cliente;
    Session sessao;
    
    
    public ClienteDAOImplTest() {
        clienteDAO = new ClienteDAOImpl();
    }
//    @Test
    public void testSalvar(){
        cliente = new Cliente(Gerador.gerarNome(), Gerador.gerarCpf(), 
                Gerador.gerarCnpj(), Double.valueOf(Gerador.gerarNumero(4)));
        sessao = HibernateUtil.abrirConexao();
        clienteDAO.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());
        
    }
//    @Test
    public void testAlterar(){
        System.out.println("alterar");
        pesquisarClienteBd();
        cliente.setNome(gerarNome());
        sessao = HibernateUtil.abrirConexao();
        clienteDAO.salvarOuAlterar(cliente, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        Cliente clientePesquisado = clienteDAO.pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        assertEquals(cliente.getNome(), clientePesquisado.getNome());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        pesquisarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        Cliente clientePesq = clienteDAO.pesquisarPorId(cliente.getId(), sessao);
        assertEquals(clientePesq, cliente);
        sessao.close();
    }
    
//    @Test
    public void testExcluir(){
        System.out.println("excluir");
        pesquisarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        clienteDAO.excluir(cliente, sessao); 
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        cliente = clienteDAO.pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        assertNull(cliente);
    }
    
    @Test
    public void testPesquisarPorNome(){
        System.out.println("pesquisarPorNome");
        pesquisarClienteBd();
        List<Cliente> clientes = clienteDAO.pesquisarPorNome(cliente.getNome(), sessao);
        assertNotNull(clientes);
    }
    
    public Cliente pesquisarClienteBd(){
        sessao = HibernateUtil.abrirConexao();
        Query<Cliente> consulta = sessao.createQuery("from Cliente c");
        List<Cliente> clientes = consulta.getResultList();
        sessao.close();
        if (clientes.isEmpty()){
            testSalvar();
        } else{
            cliente = clientes.get(0);
        }
        return cliente;
    }
}
