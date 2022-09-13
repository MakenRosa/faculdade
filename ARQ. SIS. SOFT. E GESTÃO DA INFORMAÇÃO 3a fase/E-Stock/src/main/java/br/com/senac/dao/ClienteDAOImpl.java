/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Truen
 */
public class ClienteDAOImpl extends BaseDAOImpl<Cliente, Long> implements ClienteDAO{

    @Override
    public Cliente pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Cliente.class, id);
    }
    
    public Cliente gerarClienteBd(Session sessao) throws HibernateException{
        Query<Cliente> consulta = sessao.createQuery("from Cliente c");
        consulta.setMaxResults(1);
        Cliente cliente = consulta.getSingleResult();
        sessao.close();
        return cliente;
    }
    
}
