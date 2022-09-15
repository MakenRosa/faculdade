/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemEntrada;
import br.com.senac.entidade.Produto;
import java.time.LocalDate;
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
    public List<Produto> gerarRelatorioEntrada(LocalDate de, LocalDate ate, Session sessao) throws HibernateException{
        Query<Produto> consulta = sessao.createQuery("SELECT p.nome, ie.qtdProduto " +
"FROM Produto p " +
"JOIN p.itensEntrada ie");
        return consulta.getResultList();
    }
    
}
