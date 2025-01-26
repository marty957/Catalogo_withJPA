package org.example.Excpetion;

public class PersistenzaDati extends RuntimeException {
    public PersistenzaDati(String message) {
        super(message);
    }
}
