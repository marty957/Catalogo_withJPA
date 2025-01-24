package org.example.entities;

import org.example.Enumeration.GenereLetterario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Libro extends Pubblicazione{

    @Column(nullable = false)
    private String autore;
    @Enumerated(EnumType.STRING)
    private GenereLetterario genere;

    public Libro() {

    }

    public Libro(String titolo, long annoPubblicazione, long numeroPagine,
                 String autore, GenereLetterario genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public GenereLetterario getGenere() {
        return genere;
    }

    public void setGenere(GenereLetterario genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                "} " + super.toString();
    }
}

