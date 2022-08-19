/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        cliente = pesquisarClienteBd();
        cliente.setNome(Gerador.gerarNome());
        clienteDAO.alterar(cliente);
    }

//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        clienteDAO.excluir(1);
    }

//    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisar por id!");
        cliente = clienteDAO.pesquisarPorId(5);
        System.out.println(cliente.getNome());
        assertNotNull(cliente.getId());
    }

//    @Test
    public void testPesquisarTodos() throws Exception {
        System.out.println("pesquisarTodos");
        List<Cliente> clientes = clienteDAO.pesquisarTodos();
        for (Cliente cliente1 : clientes) {
            System.out.println(cliente1.getNome());
        }
    }

    @Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("PesquisarPorNome");
        List<Cliente> clientes = clienteDAO.PesquisarPorNome("Silva-");
        for (Cliente cliente1 : clientes) {
            System.out.println(cliente1.getNome());
        }
    }

    private Cliente pesquisarClienteBd() throws Exception{
        String sql = "SELECT * FROM cliente LIMIT 1";
        Connection conexao = FabricaConexao.abrirConexao();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        ResultSet res = pstm.executeQuery();
        if (res.next()){
            Cliente clienteL = new Cliente(res.getString("nome"),
                    res.getString("cpf"),
                    res.getString("rg"),
                    res.getDouble("salario"));
            clienteL.setId(res.getInt("id"));
            return clienteL;
        } else{
            testSalvar();
        }
        return null;
    }
    
}
