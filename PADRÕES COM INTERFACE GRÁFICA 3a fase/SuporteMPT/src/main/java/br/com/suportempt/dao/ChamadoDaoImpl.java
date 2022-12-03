package br.com.suportempt.dao;

import br.com.suportempt.entidade.Chamado;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ChamadoDaoImpl extends BaseDaoImpl<Chamado, Long> implements ChamadoDao{

    @Override
    public Chamado pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Chamado.class, id);
    }

    @Override
    public List<Chamado> pesquisarPorPatrimonio(String patrimonio, Session sessao) throws HibernateException {
        Query<Chamado> consulta = sessao.createQuery("FROM Chamado c WHERE c.patrimonio LIKE :patrimonio ORDER BY c.patrimonio");
        consulta.setParameter("patrimonio", "%" + patrimonio + "%");
        return consulta.getResultList();
    }
    
    @Override
    public List<Chamado> pesquisarPorPatrimonioEAtivo(String patrimonio, Session sessao) throws HibernateException {
        Query<Chamado> consulta = sessao.createQuery("FROM Chamado c WHERE c.patrimonio = :patrimonio AND c.ativo = true ORDER BY c.patrimonio");
        consulta.setParameter("patrimonio", patrimonio);
        return consulta.getResultList();
    }

    @Override
    public List<Chamado> pesquisarPorEquipamento(String equipamento, Session sessao) throws HibernateException {
        Query<Chamado> consulta = sessao.createQuery("FROM Chamado c WHERE c.equipamento LIKE :equipamento ORDER BY c.equipamento");
        consulta.setParameter("equipamento", "%" + equipamento + "%");
        return consulta.getResultList();
    }

    @Override
    public List<Chamado> pesquisarPorSala(String sala, Session sessao) throws HibernateException {
        Query<Chamado> consulta = sessao.createQuery("FROM Chamado c WHERE c.sala LIKE :sala ORDER BY c.sala");
        consulta.setParameter("sala", "%" + sala + "%");
        return consulta.getResultList();
    }

    @Override
    public List<Chamado> pesquisarPorData(Date data, Session sessao) throws HibernateException {
        Query<Chamado> consulta = sessao.createQuery("FROM Chamado c WHERE c.dtAbertura LIKE :data ORDER BY c.dtAbertura");
        consulta.setParameter("data", "%" + data + "%");
        return consulta.getResultList();
    }

    @Override
    public List<Chamado> pesquisarTodosAtivo(Session sessao) throws HibernateException {
        Query<Chamado> consulta = sessao.createQuery("FROM Chamado c WHERE c.ativo = true ORDER BY c.id");
        return consulta.getResultList();
    }

    @Override
    public List<Chamado> pesquisarTodos(Session sessao) throws HibernateException {
        Query<Chamado> consulta = sessao.createQuery("FROM Chamado c ORDER BY c.id");
        return consulta.getResultList();
    }
}
