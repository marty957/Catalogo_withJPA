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


        Faker faker = new Faker(new Locale("it"));

        PubblicazioneDao pubblicazioneDao=new PubblicazioneDao(em);
        PrestitoDAO prestitoDAO=new PrestitoDAO(em);
        UtenteDao utenteDao=new UtenteDao(em);

        List<Pubblicazione> pubblicazioniPrestate= new ArrayList<>();

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
//
//        pubblicazioniPrestate.addAll(Arrays.asList(l1,r1));
//
//        pubblicazioneDao.save(l1);
//        pubblicazioneDao.save(r1);
//
//        Utente u2=new Utente(faker.name().firstName(),faker.name().lastName(),
//                LocalDate.of(1967,11,2),"AA002");
//        utenteDao.save(u2);
//
//
  //       Prestito p1=new Prestito(LocalDate.of(2025,1,7),
   //            LocalDate.of(2025,1,25),u2,pubblicazioniPrestate);
   //     System.out.println(p1);
//        prestitoDAO.save(p1);












        emf.close();
        em.close();

    }
}
