/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Truen
 */
public interface ClienteDAO extends BaseDAO<Cliente, Long>{
    public Cliente gerarClienteBd(Session sessao) throws HibernateException;
}
