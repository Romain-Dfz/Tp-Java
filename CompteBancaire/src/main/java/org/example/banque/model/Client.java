package com.banque.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private String identifiant;
    private String numeroTelephone;
    private List<CompteBancaire> comptes;

    public Client(String nom, String prenom, String identifiant, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.numeroTelephone = numeroTelephone;
        this.comptes = new ArrayList<>();
    }

    // Getters et setters

    public void ajouterCompte(CompteBancaire compte) {
        comptes.add(compte);
    }
}
