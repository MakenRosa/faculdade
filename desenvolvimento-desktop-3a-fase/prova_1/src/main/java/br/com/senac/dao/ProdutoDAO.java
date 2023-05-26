/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Produto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author maken.rosa
 */
public interface ProdutoDAO extends BaseDAO<Produto, Long>{
    public List<Produto> pesquisarPorNome(String nome, Session sessao);
}
