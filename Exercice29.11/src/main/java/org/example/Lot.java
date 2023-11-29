package org.example;

public class Lot {
    private Article article;
    private int quantite;
    private double remisePourcentage;

    public Lot(Article article, int quantite, double remisePourcentage) {
        this.article = article;
        this.quantite = quantite;
        this.remisePourcentage = remisePourcentage;
    }
}
