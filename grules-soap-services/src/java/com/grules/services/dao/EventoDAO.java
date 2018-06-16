package com.grules.services.dao;

import com.grules.lib.Evento;
import com.grules.services.util.Util;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class EventoDAO {

    @PersistenceContext(unitName = Util.persistenceUnit)
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(Evento entity) {
        getEntityManager().persist(getEntityManager().merge(entity));
    }

    public void update(Evento entity) {
        getEntityManager().merge(entity);
    }

    public void delete(Object id) {
        Evento entity = getEntityManager().find(Evento.class, id);
        getEntityManager().remove(entity);
    }

    public Evento find(Object id) {
        return getEntityManager().find(Evento.class, id);
    }

    public List<Evento> loadAll() {
        TypedQuery query = entityManager.createQuery("SELECT e FROM Evento e", Evento.class);
        return query.getResultList();
    }
    
    public Evento loadBySemestre(String semestre) {
        TypedQuery query = entityManager.createQuery("SELECT e FROM Evento e WHERE e.semestre = :semestre", Evento.class);
        query.setParameter("semestre", semestre);
        try{
            return (Evento) query.getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }
}
