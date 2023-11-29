package org.example;

public class Stylo extends Article {
    private final String couleur;

    public Stylo(String reference, String nom, double prixUnitaire, String couleur) {
        super(reference, nom, prixUnitaire);
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Stylo{" +
                "couleur='" + couleur + '\'' +
                "} " + super.toString();
    }
}
