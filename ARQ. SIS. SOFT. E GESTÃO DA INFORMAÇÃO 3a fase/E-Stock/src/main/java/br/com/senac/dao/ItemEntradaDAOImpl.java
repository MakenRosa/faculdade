/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemEntrada;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Truen
 */
public class ItemEntradaDAOImpl extends BaseDAOImpl<ItemEntrada, Long> implements ItemEntradaDAO{

    @Override
    public ItemEntrada pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(ItemEntrada.class, id);
    }
    
    @Override
    public ItemEntrada gerarItemEntradaBd(Session sessao) throws HibernateException{
    Query<ItemEntrada> consulta = sessao.createQuery("from ItemEntrada ie");
    consulta.setMaxResults(1);
    ItemEntrada item = consulta.getSingleResult();
        return item;
    }
    
}
