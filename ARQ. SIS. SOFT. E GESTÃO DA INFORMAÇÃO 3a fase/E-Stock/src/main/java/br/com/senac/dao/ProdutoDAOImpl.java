/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Produto;
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
    public Produto buscarProdutoBd(Session sessao) throws HibernateException{
        Query<Produto> consulta = sessao.createQuery("from Produto p");
        consulta.setMaxResults(1);
        Produto produto = consulta.getSingleResult();
        return produto;
    }
    
}
