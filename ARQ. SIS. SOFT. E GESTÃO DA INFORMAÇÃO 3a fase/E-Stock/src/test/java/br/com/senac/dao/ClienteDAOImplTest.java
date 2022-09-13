/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.util.Gerador;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Truen
 */
public class ClienteDAOImplTest {
    private final ClienteDAO clienteDAO;
    private Cliente cliente;
    private Session sessao;

    public ClienteDAOImplTest() {
        clienteDAO = new ClienteDAOImpl();
    }
    
    
    @Test
    public void testSalvar(){
        System.out.println("salvar");
        cliente = new Cliente(Gerador.gerarNome(), Gerador.gerarCpf(),
        Gerador.gerarTelefoneCelular());
        sessao = HibernateUtil.abrirConexao();
        clienteDAO.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getIdCliente());
    }
//    @Test
    public void testAlterar(){
        System.out.println("alterar");
        gerarClienteBd();
        List<String> produts = Gerador.gerarProduto();
        cliente.setNome(produts.get(0));
        cliente.setNome(Gerador.gerarNome());
        sessao = HibernateUtil.abrirConexao();
        clienteDAO.salvarOuAlterar(cliente, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        Cliente clientePesquisado = clienteDAO.pesquisarPorId(cliente.getIdCliente(), sessao);
        sessao.close();
        assertEquals(cliente.getIdCliente(), clientePesquisado.getIdCliente());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        gerarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        Cliente clientePesquisado = clienteDAO.pesquisarPorId(cliente.getIdCliente(), sessao);
        sessao.close();
        System.out.println(clientePesquisado.getNome());
        assertNotNull(clientePesquisado);
    }
    
//    @Test
    public void testExcluir(){
        System.out.println("excluir");
        gerarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        clienteDAO.excluir(cliente, sessao);
        Cliente clienteExcluido = clienteDAO.pesquisarPorId(cliente.getIdCliente(), sessao);
        assertNull(clienteExcluido);
    }
    
    public void gerarClienteBd(){
        sessao = HibernateUtil.abrirConexao();
        Query<Cliente> consulta = sessao.createQuery("from Cliente c");
        consulta.setMaxResults(1);
        cliente = consulta.getSingleResult();
        sessao.close();
        if (cliente == null){
            testSalvar();
        }
    }
}
