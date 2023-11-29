package org.example;

public class Facture {
    private static int numeroFacture = 1;
    private int numero;
    private String client;
    private String date;
    private LigneFacture[] lignes;

    public Facture(String client, String date) {
        this.numero = numeroFacture++;
        this.client = client;
        this.date = date;
        this.lignes = new LigneFacture[10];
    }

    public void ajouterLigne(Article article, int quantite) {
        for (int i = 0; i < lignes.length; i++) {
            if (lignes[i] == null) {
                lignes[i] = new LigneFacture(article, quantite);
                break;
            }
        }
    }

    public double getPrixTotal() {
        double total = 0;
        for (LigneFacture ligne : lignes) {
            if (ligne != null) {
                total += ligne.quantite * ligne.article.getPrixUnitaire();
            }
        }
        return total;
    }

    public LigneFacture[] getLignes() {
        return new LigneFacture[0];
    }
}
