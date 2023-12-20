package org.example.banque.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private List<CompteBancaire> comptes;

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.comptes = new ArrayList<>();
    }

    public String getIdentifiant() {
        return null;
    }
}
