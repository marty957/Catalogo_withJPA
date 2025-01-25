package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Prestito.prestitoScaduto",query = "SELECT p FROM Prestito p " +
        "WHERE p.restituzionePrevista < CURRENT_DATE AND p.restituzioneEffettiva IS NULL")
public class Prestito {

    @Id
    @GeneratedValue
    private long id_prestito;
    @Column(nullable = false)
    private LocalDate inizioPrestito;
    @Column(nullable = false)
    private LocalDate restituzionePrevista;
    private LocalDate restituzioneEffettiva;
    @ManyToOne
    private Utente utente;


    @ManyToMany
    @JoinTable(
            name = "prestiti_pubblicazioni",
            joinColumns = @JoinColumn(name = "prestito_id"),
            inverseJoinColumns = @JoinColumn(name = "pubblicazione_id")
    )
    private List<Pubblicazione> listaPubblicazioni= new ArrayList<>();

    public Prestito() {
    }

    public Prestito(LocalDate inizioPrestito,  LocalDate restituzioneEffettiva,
                    Utente utente, List<Pubblicazione> listaPubblicazioni) {
        this.inizioPrestito = inizioPrestito;
        restituzionePrevista = inizioPrestito.plusDays(30);
        this.restituzioneEffettiva = restituzioneEffettiva;
        this.utente = utente;
        this.listaPubblicazioni = listaPubblicazioni;
    }

    public long getId_prestito() {
        return id_prestito;
    }

    public void setId_prestito(long id_prestito) {
        this.id_prestito = id_prestito;
    }

    public LocalDate getInizioPrestito() {
        return inizioPrestito;
    }

    public void setInizioPrestito(LocalDate inizioPrestito) {
        this.inizioPrestito = inizioPrestito;
    }

    public LocalDate getRestituzionePrevista() {
        return restituzionePrevista;
    }

    public void setRestituzionePrevista(LocalDate restituzionePrevista) {
        this.restituzionePrevista = restituzionePrevista;
    }

    public LocalDate getRestituzioneEffettiva() {
        return restituzioneEffettiva;
    }

    public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
        this.restituzioneEffettiva = restituzioneEffettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Pubblicazione> getListaPubblicazioni() {
        return listaPubblicazioni;
    }

    public void setListaPubblicazioni(List<Pubblicazione> listaPubblicazioni) {
        this.listaPubblicazioni = listaPubblicazioni;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id_prestito=" + id_prestito +
                ", inizioPrestito=" + inizioPrestito +
                ", restituzionePrevista=" + restituzionePrevista +
                ", restituzioneEffettiva=" + restituzioneEffettiva +
                ", utente=" +  (utente!=null? utente.getNome()+utente.getCognome():"N/A")+
                ", listaPubblicazioni=" + listaPubblicazioni +
                '}';
    }
}
