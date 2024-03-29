/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Maken.Rosa
 */
public interface UsuarioDAO extends BaseDAO<Usuario, Long> {

    List<Usuario> pesquisarPorNome(String nome, boolean status,
            Session sessao) throws HibernateException;
    
    List<Usuario> pesquisarTodos(Session sessao) throws HibernateException;

    Usuario logar(String login, String senha,
            Session sessao) throws HibernateException;
}
