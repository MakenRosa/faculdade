/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemEntrada;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Truen
 */
public class ItemEntradaDAOImpl extends BaseDAOImpl<ItemEntrada, Long> implements ItemEntradaDAO{

    @Override
    public ItemEntrada pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(ItemEntrada.class, id);
    }
    
    
}
