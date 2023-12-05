package org.example;
public class Produit {
    private final String nom;
    private final double prix;
    private final String categorie;

    public Produit(String nom, double prix, String categorie) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public String getCategorie() {
        return categorie;
    }
}
