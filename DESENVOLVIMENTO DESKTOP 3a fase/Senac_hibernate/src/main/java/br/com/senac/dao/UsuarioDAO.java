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
 * @author maken.rosa
 */
public interface UsuarioDAO extends BaseDAO<Usuario, Long>{
    public List<Usuario> pesquisarTodos(Session sessao)throws HibernateException;
    public List<Usuario> pesquisarPorNome(String nome, Session sessao)throws HibernateException;
    public Usuario fazerLogin(String nomeUsuario, String senha, Session sessao) throws HibernateException;
}
