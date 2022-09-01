/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author maken.rosa
 */
public class ClienteDAOImpl extends BaseDAOImpl<Cliente, Long> implements ClienteDAO {

    @Override
    public Cliente pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> pesquisarPorNome(String nome, Session sessao) {
        sessao = HibernateUtil.abrirConexao();
        Query<Cliente> consulta = sessao.createQuery("from Cliente c where c.nome like :nome");
        consulta.setParameter("nome", "%"+nome+"%");
        List<Cliente> clientes = consulta.getResultList();
        sessao.close();
        return clientes;
    }
}
