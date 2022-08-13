/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Gerador;
/**
 *
 * @author maken.rosa
 */
public class ClienteDAOImplTest {
    private Cliente cliente;
    private final ClienteDAOImpl clienteDAO;
    
    public ClienteDAOImplTest() {
        clienteDAO = new ClienteDAOImpl();
    }

//    @Test
    public void testSalvar() throws Exception {
        String salario = Gerador.gerarNumero(1) + "." + Gerador.gerarNumero(3);
        cliente = new Cliente(Gerador.gerarNome(),
        Gerador.gerarCpf(),
        Gerador.gerarNumero(8),
        Double.parseDouble(salario));
        clienteDAO.salvar(cliente);
        assertNotNull(cliente.getId());
    }

//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Cliente cliente = null;
        ClienteDAOImpl instance = new ClienteDAOImpl();
        instance.alterar(cliente);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Integer id = null;
        ClienteDAOImpl instance = new ClienteDAOImpl();
        instance.excluir(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisar por id!");
        cliente = clienteDAO.pesquisarPorId(5);
        System.out.println(cliente.getNome());
        assertNotNull(cliente.getId());
    }

//    @Test
    public void testPesquisarTodos() throws Exception {
        System.out.println("pesquisarTodos");
        ClienteDAOImpl instance = new ClienteDAOImpl();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.pesquisarTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("PesquisarPorNome");
        String nome = "";
        ClienteDAOImpl instance = new ClienteDAOImpl();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.PesquisarPorNome(nome);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
