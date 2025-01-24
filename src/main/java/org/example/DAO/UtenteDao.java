package org.example.DAO;

import org.example.entities.Utente;

import javax.persistence.EntityManager;

public class UtenteDao {
    private EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente u){
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }

    public Utente getById(long id){
        return em.find(Utente.class,id);
    }

    public void delete(Utente u){
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
    }
}
