/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Produto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Truen
 */
public class ProdutoDAOImpl extends BaseDAOImpl<Produto, Long> implements ProdutoDAO{

    @Override
    public Produto pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Produto.class, id);
    }
    
    @Override
    public List<Produto> pesquisarTodos(Session sessao) throws HibernateException{
        Query<Produto> consulta = sessao.createQuery("FROM Produto p");
        return consulta.getResultList();
    }
    
}
