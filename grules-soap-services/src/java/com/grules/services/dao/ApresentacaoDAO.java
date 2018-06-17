package com.grules.services.dao;

import com.grules.lib.Apresentacao;
import com.grules.services.util.Util;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
     
}
