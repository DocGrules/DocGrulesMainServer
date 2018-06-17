package com.grules.services.dao;

import com.grules.lib.Aluno;
import com.grules.services.util.Util;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class AlunoDAO {
    
    @PersistenceContext(unitName = Util.persistenceUnit)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(Aluno entity) {
        getEntityManager().persist(getEntityManager().merge(entity));
    }

    public void update(Aluno entity) {
        getEntityManager().merge(entity);
    }

    public void delete(Object id) {
        Aluno entity = getEntityManager().find(Aluno.class, id);
        getEntityManager().remove(entity);
    }

    public Aluno find(Object id) {
        return getEntityManager().find(Aluno.class, id);
    }

    public List<Aluno> loadAll() {
        TypedQuery query = entityManager.createQuery("SELECT a FROM Aluno a", Aluno.class);
        return query.getResultList();
    }
       
}
