/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Produto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author maken.rosa
 */
public class ProdutoDAOImpl extends BaseDAOImpl<Produto, Long> implements ProdutoDAO{

    @Override
    public Produto pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Produto.class, id);
    }
    @Override
    public List<Produto> pesquisarPorNome(String nome, Session sessao) {
        sessao = HibernateUtil.abrirConexao();
        Query<Produto> consulta = sessao.createQuery("from Produto p where p.nome like :nome");
        consulta.setParameter("nome", "%"+nome+"%");
        List<Produto> produtos = consulta.getResultList();
        sessao.close();
        return produtos;
    }
}
