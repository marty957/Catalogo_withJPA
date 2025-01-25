package org.example;

import com.github.javafaker.Faker;
import org.example.DAO.PrestitoDAO;
import org.example.DAO.PubblicazioneDao;
import org.example.DAO.UtenteDao;
import org.example.Enumeration.GenereLetterario;
import org.example.Enumeration.Periodicita;
import org.example.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneCata");
    private static EntityManager em = emf.createEntityManager();


    public static void main( String[] args ) {
        //settings di partenza
        Faker faker = new Faker(new Locale("it"));
        PubblicazioneDao pubblicazioneDao=new PubblicazioneDao(em);
        PrestitoDAO prestitoDAO=new PrestitoDAO(em);
        UtenteDao utenteDao=new UtenteDao(em);

        //creazione dati per DB

        //Pubblicazioni:

        Libro l1=new Libro("Il libro della giungla",1930,1203,"Kipling", GenereLetterario.AVVENTURA);
        Libro l2=new Libro("Twilight",2005,452,"Stepheie Meyer",GenereLetterario.HORROR);
        Libro l3=new Libro("Il signore degli anelli",1954, 1408,"Tolkien",GenereLetterario.FANTASY);
        Libro l4=new Libro("Assasionio sull'Orient Express",1934,278,"Aghata Christie",GenereLetterario.GIALLO);
        Libro l5=new Libro("Il libro della giungla 2- ritorno nel vecchio mondo",1936,903,"Kipling", GenereLetterario.AVVENTURA);
        Libro l6=new Libro("New Moon",2007,446,"Stepheie Meyer",GenereLetterario.HORROR);
        Libro l7=new Libro("Lo Hobbit",1937, 304,"Tolkien",GenereLetterario.FANTASY);
        Libro l8=new Libro("Poirot sul Nilo", 1937,605,"Aghata Christie",GenereLetterario.GIALLO);

        Rivista r1=new Rivista("La Settimana Enigmistica",1940,50, Periodicita.SETTIMANALE);
        Rivista r2= new Rivista("Panorama",1962,65,Periodicita.SETTIMANALE);
        Rivista r3= new Rivista("Focus", 1992,55,Periodicita.MENSILE);
        Rivista r4= new Rivista("Humanitas",2006,62,Periodicita.MENSILE);
        Rivista r5= new Rivista("Newton",1956,96,Periodicita.ANNUALE);
        Rivista r6 =new Rivista("Giornale di Matematiche",1965,87,Periodicita.ANNUALE);
        Rivista r7=new Rivista("giornale",2015,29,Periodicita.SETTIMANALE);

        List<Pubblicazione> catalogo=new ArrayList<>();
        catalogo.addAll(Arrays.asList(l1,l2,l3,l4,l5,l6,l7,l8,r1,r2,r3,r4,r5,r6,r7));

        //Utenti:
        Utente u1=new Utente(faker.name().firstName(),faker.name().lastName(),
                LocalDate.of(1967,11,2),"AA001");
        Utente u2=new Utente(faker.name().firstName(),faker.name().lastName(),
                LocalDate.of(1984,12,9),"AA002");
        Utente u3=new Utente(faker.name().firstName(),faker.name().lastName(),
                LocalDate.of(1976,3,25),"AA003");
        Utente u4=new Utente(faker.name().firstName(),faker.name().lastName(),
                LocalDate.of(1990,10,30),"AA004");
        Utente u5=new Utente(faker.name().firstName(),faker.name().lastName(),
                LocalDate.of(1969,7,21),"AA005");

        //liste per prestiti
        List<Pubblicazione> pubblicazioniPrestate1= new ArrayList<>();
        List<Pubblicazione> pubblicazioniPrestate2= new ArrayList<>();
        List<Pubblicazione> pubblicazioniPrestate3= new ArrayList<>();
        List<Pubblicazione> pubblicazioniPrestate4= new ArrayList<>();

        pubblicazioniPrestate1.addAll(Arrays.asList(l1,r1));
        pubblicazioniPrestate2.addAll(Arrays.asList(l4,r5,l2));
        pubblicazioniPrestate3.addAll(Arrays.asList(l6,l8,r4));
        pubblicazioniPrestate4.addAll(Arrays.asList(r6,l7,r4));

        //salvataggio pubblicazioni
//        pubblicazioneDao.save(l1);
//        pubblicazioneDao.save(l2);
//        pubblicazioneDao.save(l3);
//        pubblicazioneDao.save(l4);
//        pubblicazioneDao.save(l5);
//        pubblicazioneDao.save(l6);
//        pubblicazioneDao.save(l7);
//        pubblicazioneDao.save(l8);
//        pubblicazioneDao.save(r1);
//        pubblicazioneDao.save(r2);
//        pubblicazioneDao.save(r3);
//        pubblicazioneDao.save(r4);
//        pubblicazioneDao.save(r5);
//        pubblicazioneDao.save(r6);
//        pubblicazioneDao.save(r7);
//        pubblicazioneDao.delete(r7.getIsbn());





        //salvataggio utenti

//        utenteDao.save(u1);
//        utenteDao.save(u2);
//        utenteDao.save(u3);
//        utenteDao.save(u4);
//        utenteDao.save(u5);

        //Prestiti creazione:

        Prestito p1=new Prestito(LocalDate.of(2024,10,14),
               LocalDate.of(2024,12,5),u1,pubblicazioniPrestate1);
        Prestito p2=new Prestito(LocalDate.of(2024,5,31),
                LocalDate.of(2024,9,25),u2,pubblicazioniPrestate1);
        Prestito p3=new Prestito(LocalDate.of(2025,1,7),
                LocalDate.of(2025,1,22),u3,pubblicazioniPrestate1);
        Prestito p4=new Prestito(LocalDate.of(2025,1,2),
                null,u4,pubblicazioniPrestate1);
        Prestito p5=new Prestito(LocalDate.of(2024,10,4),
                null,u5,pubblicazioniPrestate1);


        //salvataggio prestiti:
//        prestitoDAO.save(p1);
//        prestitoDAO.save(p2);
//        prestitoDAO.save(p3);
//        prestitoDAO.save(p4);
//        prestitoDAO.save(p5);



        List<Pubblicazione> ricercaPerAnno=  pubblicazioneDao.trovaPerAnnoPub(2005);
        ricercaPerAnno.forEach(System.out::println);

        List<Pubblicazione> ricercaPerAutore=pubblicazioneDao.trovaPerAutore("Tolkien");
        ricercaPerAutore.forEach(System.out::println);

        List<Pubblicazione> ricercaPerTitolo=pubblicazioneDao.trovaPerTitolo("A");
        ricercaPerTitolo.forEach(System.out::println);

        List<Prestito> ricercaPrestitiScaduti=prestitoDAO.prestitoScaduto();
        ricercaPrestitiScaduti.forEach(System.out::println);

        emf.close();
        em.close();

    }
}
