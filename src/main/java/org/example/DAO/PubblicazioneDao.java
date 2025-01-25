package org.example.DAO;

import org.example.entities.Prestito;
import org.example.entities.Pubblicazione;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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

    public void delete(long id){
        Pubblicazione p=em.find(Pubblicazione.class,id);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        System.out.println("PUBBLICAZIONE: " +p +"E' STATA RIMOSSA");
    }

    public List<Pubblicazione> trovaPerAnnoPub(long anno) {
        Query q = em.createNamedQuery("Pubblicazione.trovaPerAnnoPub");
        q.setParameter("anno", anno);
        return q.getResultList();
    }

    public List<Pubblicazione> trovaPerAutore(String autore){
        Query q = em.createNamedQuery("Pubblicazione.trovaPerAutore");
        q.setParameter("autore",autore);
        return q.getResultList();
    }

    public List<Pubblicazione> trovaPerTitolo(String titolo){
        Query q= em.createNamedQuery("Pubblicazione.trovaPerTitolo");
        q.setParameter("titolo" ,"%"+ titolo+"%");
        return q.getResultList();
    }
}
