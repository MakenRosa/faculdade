/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemEntrada;
import br.com.senac.entidade.Produto;
import java.sql.Date ;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
    public List<ItemEntrada> gerarRelatorioEntrada(String de, String ate, Session sessao) throws HibernateException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Query<ItemEntrada> consulta = sessao.createQuery("FROM ItemEntrada ie WHERE ie.dataEntrada BETWEEN :de AND :ate ORDER BY ie.produto.nome");
        consulta.setParameter("de", LocalDate.parse(de, formatter));
        consulta.setParameter("ate", LocalDate.parse(ate, formatter));
        return consulta.getResultList();
    }
    
}
