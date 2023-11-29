package org.example;

public class LigneFacture {
    Article article;
    int quantite;

    public LigneFacture(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public void afficherLigne() {
        double prixTotal = quantite * article.getPrixUnitaire();
        System.out.println(quantite + " - " + article.getReference() + " - " +
                article.getNom() + " - " + article.getPrixUnitaire() + " - " + prixTotal);
    }
}
