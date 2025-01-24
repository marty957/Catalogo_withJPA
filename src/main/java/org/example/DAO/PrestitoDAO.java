package org.example.DAO;

import org.example.entities.Prestito;

import javax.persistence.EntityManager;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public Prestito getById(long id){
        return em.find(Prestito.class,id);

    }

    public void delete(Prestito p){
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
}
