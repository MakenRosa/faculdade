/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemSaida;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Truen
 */
public class ItemSaidaDAOImpl extends BaseDAOImpl<ItemSaida, Long> implements ItemSaidaDAO{

    @Override
    public ItemSaida pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(ItemSaida.class, id);
    }
    
}
