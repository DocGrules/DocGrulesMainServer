package com.grules.services.dao;

import com.grules.lib.Apresentacao;
import com.grules.lib.RelatorioApresentacao;
import com.grules.services.util.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ApresentacaoDAO {

    @PersistenceContext(unitName = Util.persistenceUnit)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(Apresentacao entity) {
        getEntityManager().persist(getEntityManager().merge(entity));
    }

    public void update(Apresentacao entity) {
        getEntityManager().merge(entity);
    }

    public void delete(Object id) {
        Apresentacao entity = getEntityManager().find(Apresentacao.class, id);
        getEntityManager().remove(entity);
    }

    public Apresentacao find(Object id) {
        return getEntityManager().find(Apresentacao.class, id);
    }

    public List<Apresentacao> loadAll() {
        TypedQuery query = entityManager.createQuery("SELECT ap FROM Apresentacao ap", Apresentacao.class);
        return query.getResultList();
    }

    public List<RelatorioApresentacao> loadApresentacoesPorDia(Integer eventoId) {
        List<RelatorioApresentacao> result = new ArrayList<>();
        TypedQuery qa = entityManager.createQuery("SELECT DISTINCT(a.dataHora) FROM Apresentacao a WHERE a.evento.id = :eventoId", Apresentacao.class);
        qa.setParameter("eventoId", eventoId);
        List<Date> datas = qa.getResultList();
        for (Date d : datas) {
            result.add(new RelatorioApresentacao(d, loadByData(d, eventoId)));
        }
        return result;
    }

    public List<Apresentacao> loadByData(Date date, Integer eventoId) {
        TypedQuery query = entityManager.createQuery("SELECT ap FROM Apresentacao ap WHERE ap.dataHora = :date AND ap.evento.id = :eventoId", Apresentacao.class);
        query.setParameter("eventoId", eventoId);
        query.setParameter("date", date);
        return query.getResultList();
    }

}
