/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.ItemSaida;
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
public class ItemSaidaDAOImpl extends BaseDAOImpl<ItemSaida, Long> implements ItemSaidaDAO {

    @Override
    public ItemSaida pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(ItemSaida.class, id);
    }

    @Override
    public List<ItemSaida> pesquisarPorPeriodo(String de, String ate, Session sessao) throws HibernateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Query<ItemSaida> consulta = sessao.createQuery("FROM ItemSaida i WHERE i.dataSaida BETWEEN :de AND :ate ORDER BY i.produto.nome");
        consulta.setParameter("de", LocalDate.parse(de, formatter));
        consulta.setParameter("ate", LocalDate.parse(ate, formatter));
        return consulta.getResultList();
    }

    @Override
    public void gerarRelatorioSaida(String de, String ate) throws HibernateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Session sessao = HibernateUtil.abrirConexao();
        List<ItemSaida> itens = pesquisarPorPeriodo(de, ate, sessao);
        System.out.println("===================================================\n"
                + "||           Relatório de Saida            \n"
                + "===================================================\n"
                + "|| Produto            || Uni|| Data      || Lote\n"
                + "===================================================");
        itens.forEach(item -> {
            System.out.println("| " + item.getProduto().getNome() + "         | " + item.getQtdProduto()
                    + " | " + item.getDataSaida().format(formatter) + "| " + item.getLote());
        });
    }

}
