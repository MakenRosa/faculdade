/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemEntrada;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Maken.Rosa
 */
public interface ItemEntradaDAO extends BaseDAO<ItemEntrada, Long>{
    public List<ItemEntrada> pesquisarPorPeriodo(String de, String ate, Session sessao) throws HibernateException;

    public void gerarRelatorioEntrada(String de, String ate) throws HibernateException;
}
