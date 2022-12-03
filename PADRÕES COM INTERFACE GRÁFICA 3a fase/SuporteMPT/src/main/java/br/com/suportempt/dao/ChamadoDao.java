package br.com.suportempt.dao;

import br.com.suportempt.entidade.Chamado;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface ChamadoDao extends BaseDao<Chamado, Long> {

    List<Chamado> pesquisarPorPatrimonio(String patrimonio, Session sessao) throws HibernateException;
    
    List<Chamado> pesquisarPorPatrimonioEAtivo(String patrimonio, Session sessao) throws HibernateException;

    List<Chamado> pesquisarPorEquipamento(String equipamento, Session sessao) throws HibernateException;

    List<Chamado> pesquisarPorSala(String sala, Session sessao) throws HibernateException;

    List<Chamado> pesquisarPorData(Date data, Session sessao) throws HibernateException;

    List<Chamado> pesquisarTodosAtivo(Session sessao) throws HibernateException;

    List<Chamado> pesquisarTodos(Session sessao) throws HibernateException;

}
