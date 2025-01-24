package org.example.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pubblicazione {

    @Id
    @GeneratedValue
    private long isbn;
    @Column(nullable = false)
    private String titolo;
    @Column(nullable = false)
    private long annoPubblicazione;
    @Column(nullable = false)
    private long numeroPagine;

    @ManyToMany(mappedBy = "listaPubblicazioni")
    private List<Prestito> listaprestiti=new ArrayList<>();

    public Pubblicazione() {
    }

    public Pubblicazione(String titolo, long annoPubblicazione, long numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public long getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(long annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public long getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(long numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Pubblicazione{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
