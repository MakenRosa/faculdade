/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemSaida;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Maken.Rosa
 */
public interface ItemSaidaDAO extends BaseDAO<ItemSaida, Long> {

    public List<ItemSaida> pesquisarPorPeriodo(String de, String ate, Session sessao) throws HibernateException;

    public void gerarRelatorioSaida(String de, String ate) throws HibernateException;
}
