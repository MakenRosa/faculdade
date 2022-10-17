/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemEntrada;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Maken.Rosa
 */
public class ItemEntradaDAOImpl extends BaseDAOImpl<ItemEntrada, Long> implements ItemEntradaDAO {

    @Override
    public ItemEntrada pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(ItemEntrada.class, id);
    }

    @Override
    public List<ItemEntrada> pesquisarPorPeriodo(String de, String ate, Session sessao) throws HibernateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Query<ItemEntrada> consulta = sessao.createQuery("FROM ItemEntrada ie WHERE ie.dataEntrada BETWEEN :de AND :ate ORDER BY ie.produto.nome");
        consulta.setParameter("de", LocalDate.parse(de, formatter));
        consulta.setParameter("ate", LocalDate.parse(ate, formatter));
        return consulta.getResultList();
    }

    @Override
    public void gerarRelatorioEntrada(String de, String ate) throws HibernateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Session sessao = HibernateUtil.abrirConexao();
        List<ItemEntrada> itens = pesquisarPorPeriodo(de, ate, sessao);
        System.out.println("===================================================\n"
                + "||             Relatório de Entrada            \n"
                + "===================================================\n"
                + "|| Produto            || Uni|| Data da Entrada || Lote   \n"
                + "===================================================");
        itens.forEach(item -> {
            System.out.println("| " + item.getProduto().getNome() + "         | " + item.getQtdProduto()
                    + " | " + item.getDataEntrada().format(formatter) + "| " + item.getLote());
        });
    }
}
