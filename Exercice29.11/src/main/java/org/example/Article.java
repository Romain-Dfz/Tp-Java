package org.example;

public abstract class Article implements ArticleUnitaire {
    private final String reference;
    private final String nom;
    private final double prixUnitaire;

    public Article(String reference, String nom, double prixUnitaire) {
        this.reference = reference;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    @Override
    public String toString() {
        return "Article{" +
                "reference='" + reference + '\'' +
                ", nom='" + nom + '\'' +
                ", prixUnitaire=" + prixUnitaire +
                '}';
    }

    public int getNom() {
        return 0;
    }
}

