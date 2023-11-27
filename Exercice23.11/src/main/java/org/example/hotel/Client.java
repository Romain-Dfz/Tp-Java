package org.example.hotel;
public class Client {
    private static int count = 1;
    private int id;
    private String nom;
    private String prenom;
    private String telephone;

    public Client(String nom, String prenom, String numéro) {
        this.id = count++;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = numéro;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }
}
