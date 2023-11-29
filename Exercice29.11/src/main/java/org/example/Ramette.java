package org.example;

public class Ramette extends Article {
    private final double grammage;

    public Ramette(String reference, String nom, double prixUnitaire, double grammage) {
        super(reference, nom, prixUnitaire);
        this.grammage = grammage;
    }

    @Override
    public String toString() {
        return "Ramette{" +
                "grammage=" + grammage +
                "} " + super.toString();
    }
}

