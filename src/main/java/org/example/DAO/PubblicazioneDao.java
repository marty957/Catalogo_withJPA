package org.example.DAO;

import org.example.entities.Pubblicazione;

import javax.persistence.EntityManager;

public class PubblicazioneDao {

    private EntityManager em;

    public PubblicazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Pubblicazione p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public Pubblicazione getById(long id){
        return em.find(Pubblicazione.class,id);
    }

    public void delete(Pubblicazione p){
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
}
