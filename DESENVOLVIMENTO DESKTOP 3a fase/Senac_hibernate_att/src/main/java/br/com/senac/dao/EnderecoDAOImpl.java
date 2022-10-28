/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Endereco;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class EnderecoDAOImpl extends BaseDaoImpl<Endereco, Long> implements EnderecoDAO, Serializable {

    @Override
    public Endereco pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Endereco.class, id);
    }
}
