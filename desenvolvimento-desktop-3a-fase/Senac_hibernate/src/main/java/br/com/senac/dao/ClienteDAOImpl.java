/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Maken.Rosa
 */
public class ClienteDAOImpl extends BaseDAOImpl<Cliente, Long>
                       implements ClienteDAO, Serializable{

    @Override
    public Cliente pesquisarPorId(Long id, Session sessao)
                                 throws HibernateException {
        return sessao.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query<Cliente> consulta = sessao
        .createQuery("from Cliente c where "
                + "c.nome like :nome order by c.nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }
    
}
