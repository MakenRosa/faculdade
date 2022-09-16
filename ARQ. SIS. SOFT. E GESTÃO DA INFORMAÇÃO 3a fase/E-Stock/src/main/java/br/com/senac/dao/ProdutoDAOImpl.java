/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemEntrada;
import br.com.senac.entidade.ItemSaida;
import br.com.senac.entidade.Produto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Maken.Rosa
 */
public class ProdutoDAOImpl extends BaseDAOImpl<Produto, Long> implements ProdutoDAO {

    @Override
    public Produto pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Produto.class, id);
    }

    @Override
    public List<Produto> pesquisarTodos(Session sessao) throws HibernateException {
        Query<Produto> consulta = sessao.createQuery("FROM Produto p");
        return consulta.getResultList();
    }

    @Override
    public void verProdutosDisponiveis() {
        List<Produto> produtos;
        try ( Session sessao = HibernateUtil.abrirConexao()) {
            produtos = pesquisarTodos(sessao);
            List<List> listaDeListas = new ArrayList();
            produtos.forEach(produto -> {
                int qtdEnt = 0;
                int qtdSai = 0;
                for (ItemEntrada item : produto.getItensEntrada()) {
                    qtdEnt += item.getQtdProduto();
                }
                for (ItemSaida item : produto.getItensSaida()) {
                    qtdSai += item.getQtdProduto();
                }
                List<String> nomeQtd = Arrays.asList(produto.getNome(), "" + (qtdEnt - qtdSai));
                listaDeListas.add(nomeQtd);
            });
            System.out.println("====================================\n"
                    + "||            PRODUTOS             ||\n"
                    + "====================================\n"
                    + "| Produto              | Uni ");
            for (List lista : listaDeListas) {
                System.out.println("| " + lista.get(0) + "    | " + lista.get(1));
            }
        }
    }
}
