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
import org.hibernate.query.Query;

/**
 *
 * @author @Maken.Rosa
 */
public class UsuarioDAOImpl extends BaseDAOImpl<Usuario, Long>
        implements UsuarioDAO {

    @Override
    public Usuario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> pesquisarPorNome(String nome, boolean status, Session sessao) throws HibernateException {
        Query<Usuario> consulta = sessao
                .createQuery("FROM Usuario u WHERE u.nome LIKE :vNome AND u.perfil.ativo = :ativo");
        consulta.setParameter("vNome", "%" + nome + "%");
        consulta.setParameter("ativo", status);
        return consulta.getResultList();
    }

    @Override
    public List<Usuario> pesquisarTodos(Session sessao) throws HibernateException {
        Query<Usuario> consulta = sessao
                .createQuery("FROM Usuario u order by u.nome");
        return consulta.getResultList();
    }

    @Override
    public Usuario logar(String login, String senha, Session sessao) throws HibernateException {
        Query<Usuario> consulta = sessao
                .createQuery("FROM Usuario u "
                        + "WHERE u.login = :login AND u.senha = :senha");
        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);
        return consulta.uniqueResult();
    }

}
