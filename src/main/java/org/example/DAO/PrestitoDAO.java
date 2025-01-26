package org.example.DAO;

import org.example.entities.Prestito;
import org.example.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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

    public List<Prestito> prestitoScaduto(){
        Query q = em.createNamedQuery("Prestito.prestitoScaduto");
        return q.getResultList();
    }

    public List<Prestito> ricercaPrestitoPerTessera(String tessera){
        Query q=em.createNamedQuery("Prestito.ricercaPrestitoPerTessera");
        q.setParameter("tessera",tessera);
        return q.getResultList();
    }

}
