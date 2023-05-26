/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.api.CepRest;
import br.com.senac.entidade.Endereco;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maken.rosa
 */
public class EnderecoDAOImplTest {
    private Endereco endereco;
    private final EnderecoDAO enderecoDAO;
    private Session sessao;
    
    public EnderecoDAOImplTest() {
        enderecoDAO = new EnderecoDAOImpl();
    }
    
    @Test
    public void testSalvar(){
        endereco = new CepRest().pesquisaCep("88111670");
        System.out.println(endereco);
        sessao = HibernateUtil.abrirConexao();
        enderecoDAO.salvarOuAlterar(endereco, sessao);
        sessao.close();
        assertNotNull(endereco.getId());
    }

//    @Test
//    public void testPesquisarPorId() {
//        System.out.println("pesquisarPorId");
//        Long id = null;
//        Session sessao = null;
//        EnderecoDAOImpl instance = new EnderecoDAOImpl();
//        Endereco expResult = null;
//        Endereco result = instance.pesquisarPorId(id, sessao);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    
        public Endereco buscarEnderecoBD(){
        String sql = "from Endereco e ";
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery(sql);
        consulta.setMaxResults(1);
        List<Endereco> enderecos = consulta.getResultList();
        sessao.close();
        if(enderecos.isEmpty()){
            testSalvar();
        }else{
            endereco = enderecos.get(0);
        }
        return endereco;
    }
}
