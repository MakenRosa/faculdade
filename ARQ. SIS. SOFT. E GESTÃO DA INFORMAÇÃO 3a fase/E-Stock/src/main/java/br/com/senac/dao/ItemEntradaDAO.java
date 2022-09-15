/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemEntrada;
import br.com.senac.entidade.Produto;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Truen
 */
public interface ItemEntradaDAO extends BaseDAO<ItemEntrada, Long>{
    public List<Produto> gerarRelatorioEntrada(LocalDate de, LocalDate ate, Session sessao) throws HibernateException;
}
